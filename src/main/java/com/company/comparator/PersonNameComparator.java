package com.company.comparator;

import com.company.models.Person;
import org.apache.log4j.Logger;

//класс для сравнения двух объектов класса Person по свойсву Name
public class PersonNameComparator implements IPersonComparator {

    private static final Logger logger = Logger.getLogger(PersonNameComparator.class);

    public int compare(Person personOne, Person personTwo) {
        logger.debug(String.format("Compare (%s) and (%s) by Name. Result: %d", personOne.toString(), personTwo.toString(), personOne.getName().compareTo(personTwo.getName())));
        return personOne.getName().compareTo(personTwo.getName());
    }
}
