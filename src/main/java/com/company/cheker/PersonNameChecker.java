package com.company.cheker;

import com.company.models.Person;
import org.apache.log4j.Logger;

//класс для проверки соответсвует ли передаваемое значение значению свойства Name класса Person
public class PersonNameChecker implements IPersonChecker{

    private static final Logger logger = Logger.getLogger(PersonNameChecker.class);

    public boolean check(Person person, Object obj) {
        boolean res = person.getName().contains((String)obj);
        logger.debug(String.format("Person Name (%s) match Name %s. Result: %s", person.toString(), obj.toString(), res));
        return res;
    }

}
