package com.company.cheker;

import com.company.models.Person;
import org.apache.log4j.Logger;


//класс для проверки соответсвует ли передаваемое значение значению свойства Age класса Person
public class PersonAgeChecker implements IPersonChecker{

    private static final Logger logger = Logger.getLogger(PersonAgeChecker.class);

    public boolean check(Person person, Object obj) {
        boolean res = obj.equals(person.getAge());
        logger.debug(String.format("Person Age (%s) match Age %s? Result: %s", person.toString(), obj.toString(), res));
        return res;
    }

}
