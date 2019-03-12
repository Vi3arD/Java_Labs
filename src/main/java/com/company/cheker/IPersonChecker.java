package com.company.cheker;

import com.company.models.Person;

//interface для проверки соответсвует ли передаваемое значение значению свойства класса Person
//с единственным методом который будет осуществлять сравнение
public interface IPersonChecker {

    /**
     * Проверка соответсвует ли передаваемое значение значению свойства класса Person
     * @param person объект класса Person
     * @param obj значение для проверки
     */
    public boolean check(Person person, Object obj);

}
