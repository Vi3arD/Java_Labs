package com.company.cheker;

import com.company.models.Person;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

//класс для проверки соответсвует ли передаваемое значение значению свойства Date of birth класса Person
public class PersonDateOfBirthChecker implements IPersonChecker{

    private static final Logger logger = Logger.getLogger(PersonDateOfBirthChecker.class);

    public boolean check(Person person, Object obj) {
        boolean res = obj.equals(person.getDateOfBirth());
        logger.debug(String.format("Person Date of birth (%s) match Date of birth %s? Result: %s", person.toString(), ((DateTime)obj).toString("dd.MM.yyyy"), res));
        return res;
    }

}
