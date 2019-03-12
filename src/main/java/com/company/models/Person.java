package com.company.models;

import com.company.collection.PersonListOur;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class Person {

    private static final Logger logger = Logger.getLogger(PersonListOur.class);

    //Enum для хранения пола Person
    public enum Sex
    {
        Male,
        Female
    }

    //храним имя
    private String name;
    //храним дату рождения
    private DateTime dateOfBirth;
    //храним пол
    private Sex sex;

    //геттеры и сеттеры для полей класса
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    //получаем возраст Person
    public int getAge() {
        return new Period(dateOfBirth, DateTime.now()).getYears();
    }

    //Получаем всю информацию о Person в виде строки
    @Override
    public String toString() {
        return String.format(" 1.Name: %s; \n 2.Date of birth: %s; \n 3.Sex: %s", name, dateOfBirth.toString("dd.MM.yyyy"), sex.toString());
    }

    //конструктор класса
    public Person(String name, DateTime dateOfBirth, Sex sex){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        logger.info(String.format("Person (%s) was initial", this.toString() ));
    }

}
