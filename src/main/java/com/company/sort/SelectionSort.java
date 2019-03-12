package com.company.sort;

import com.company.comparator.IPersonComparator;
import com.company.models.Person;
import org.apache.log4j.Logger;

//класс предназначенный для сортровки списка элементов, состоящих из объектов класса Person
//посредством использования сортровки выбором
public class SelectionSort implements IPersonSort{

    private static final Logger logger = Logger.getLogger(SelectionSort.class);

    public Person[] sort(Person[] list, IPersonComparator comparator){

        for (int min = 0; min < list.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < list.length; j++) {
                if (comparator.compare(list[j], list[least]) < 0) {
                    least = j;
                }
            }
            Person tmp = list[min];
            list[min] = list[least];
            list[least] = tmp;
        }

        logger.info(String.format("List sorted with sort: (%s) and comparator: (%s).", SelectionSort.class.getName(), comparator.getClass().getName()));
        return list;
    }

}
