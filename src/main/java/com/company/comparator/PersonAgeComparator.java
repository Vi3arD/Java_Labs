package com.company.comparator;

import com.company.models.Person;
import org.apache.log4j.Logger;


//класс для сравнения двух объектов класса Person по свойсву Age
public class PersonAgeComparator implements IPersonComparator{

    private static final Logger logger = Logger.getLogger(PersonAgeComparator.class);

    public int compare(Person personOne, Person personTwo) {
        logger.debug(String.format("Compare (%s) and (%s) by Age. Result: %d", personOne.toString(), personTwo.toString(), personOne.getAge() - personTwo.getAge()));
        return personOne.getAge() - personTwo.getAge();
    }
}
