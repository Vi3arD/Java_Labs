package com.company.collection;

import com.company.cheker.IPersonChecker;
import com.company.cheker.PersonAgeChecker;
import com.company.cheker.PersonDateOfBirthChecker;
import com.company.cheker.PersonNameChecker;
import com.company.comparator.PersonAgeComparator;
import com.company.comparator.PersonDateOfBirthComparator;
import com.company.comparator.PersonNameComparator;
import com.company.inject.Injectable;
import com.company.inject.Injector;
import com.company.models.Person;
import com.company.sort.BubbleSort;
import com.company.sort.IPersonSort;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.Arrays;

public class PersonListOur {

    private Person[] persons = new Person[10];
    private int lenght = 0;

    @Injectable
    private IPersonSort sorter;

    private static final Logger logger = Logger.getLogger(PersonListOur.class);

    public PersonListOur()
    {
        logger.info("PersonListOur was created.");
        (new Injector()).inject(this);
    }

    //получаем длину списка
    public int getLenght()
    {
        return lenght;
    }

    /**
     * Добавляет объект класса Person в список
     * @param person объект класса Person, который будет добавлен
     */
    public void addPerson(Person person)
    {
        if (lenght >= persons.length)
        {
            persons = Arrays.copyOf(persons, persons.length + (persons.length >> 1));
        }

        persons[lenght] = person;
        lenght++;
        logger.debug(String.format("Person (%s) was added.", person.toString()));
    }

    /**
     * Поиск объекта класса Person в списоке по его id
     * @param id id объекта, который необходимо найти
     * @return найденный объект или null
     */
    public Person getById(int id)
    {
        if (id < lenght) {
            logger.debug(String.format("Person with id %d was found.", id));
            return persons[id];
        }
        logger.debug(String.format("Person with id %d wasn't found.", id));
        return null;
    }

    /**
     * Удаление объекта c указанным id из list
     * @param id для удаления
     */
    public void deleteById(int id)
    {
        if (id <= lenght)
        {
            lenght--;
            for (int i = id - 1; i < lenght; i++)
            {
                persons[i] = persons[i+1];
            }

            persons[lenght] = null;
            logger.debug(String.format("Person with id %d was deleted.", id));
        }
        else
            logger.debug(String.format("Person with id %d wasn't deleted.", id));
    }

    /**
     * Поиска объекта с использованием checker
     * @param checker checker с помощью которого будет осуществляться поиск
     * @param obj значение для проверки
     * @return возвращается лист с объектами класса Person, которые подошли под условие checker
     */
    private PersonListOur search(IPersonChecker checker, Object obj)
    {
        PersonListOur res = new PersonListOur();
        for (int i = 0; i < lenght; i++)
            if(checker.check(persons[i], obj))
                res.addPerson(persons[i]);
        return res;
    }

    /**
     * Поиск по возврасту
     * @param age возраст для поиска
     * @return возвращается лист с объектами класса Person, которые подошли под условие
     */
    public PersonListOur searchByAge(int age)
    {
        logger.debug(String.format("Search in list by age: %d .", age));
        return search(new PersonAgeChecker(), age);
    }

    /**
     * Поиск по имени
     * @param name имя для поиска
     * @return возвращается лист с объектами класса Person, которые подошли под условие
     */
    public PersonListOur searchByName(String name)
    {
        logger.debug(String.format("Search in list by name: %s .", name));
        return search(new PersonNameChecker(), name);
    }

    /**
     * Поиск по дате рождения
     * @param dateOfBirth дата рождения для поиска
     * @return возвращается лист с объектами класса Person, которые подошли под условие
     */
    public  PersonListOur searchByDateOfBirth(DateTime dateOfBirth)
    {
        logger.debug(String.format("Search in list by date of birth: %s", dateOfBirth.toString("dd.MM.yyyy")));
        return search(new PersonDateOfBirthChecker(), dateOfBirth);
    }


    /**
     * Сортровка списка по полю age
     */
    public void sortByAge()
    {
        persons = sorter.sort(Arrays.copyOf(persons, lenght), new PersonAgeComparator());
    }

    /**
     * Сортровка списка по полю возраст name
     */
    public void sortByName(){
        persons = sorter.sort(Arrays.copyOf(persons, lenght), new PersonNameComparator());
    }

    /**
     * Сортровка списка по полю date of birth
     */
    public void sortByDateOfBirth()
    {
        persons = sorter.sort(Arrays.copyOf(persons, lenght), new PersonDateOfBirthComparator());
    }

    @Override
    //преобразуем лист в строку
    public String toString() {
        String res = "";
        for (int i = 0; i < lenght; i++) {
            res += String.format(" 1.Name: %s; \n 2.Date of birth: %s; \n 3.Sex: %s \n ------- \n", persons[i].getName().toString(), persons[i].getDateOfBirth().toString("dd.MM.yyyy"), persons[i].getSex().toString());
        }

        return res;
    }


}
