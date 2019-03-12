package com.company.comparator;

import com.company.models.Person;

//interface для сравнения двух объектов класса Person с единственным методом
//который будет осуществлять сравнение
public interface IPersonComparator {

    /**
     * Сравнение двух объектов класса Person
     * @param personOne объект класса Person
     * @param personTwo объект класса Person
     */
    public int compare(Person personOne, Person personTwo);

}
