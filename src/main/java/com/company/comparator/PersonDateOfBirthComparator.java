package com.company.comparator;

import com.company.models.Person;
import org.apache.log4j.Logger;

//класс для сравнения двух объектов класса Person по свойсву DateOfBirth
public class PersonDateOfBirthComparator implements IPersonComparator{

    private static final Logger logger = Logger.getLogger(PersonDateOfBirthComparator.class);

    public int compare(Person personOne, Person personTwo) {
        logger.debug(String.format("Compare (%s) and (%s) by Date of birth. Result: %d", personOne.toString(), personTwo.toString(), personOne.getDateOfBirth().compareTo(personTwo.getDateOfBirth())));
        return personOne.getDateOfBirth().compareTo(personTwo.getDateOfBirth());
    }

}
