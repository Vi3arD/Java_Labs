package com.company.sort;

import com.company.comparator.IPersonComparator;
import com.company.models.Person;
import org.apache.log4j.Logger;

//класс предназначенный для сортровки списка элементов, состоящих из объектов класса Person
//посредством использования пузырьковой сортровки
public class BubbleSort implements IPersonSort{

    private static final Logger logger = Logger.getLogger(BubbleSort.class);

    public Person[] sort(Person[] list, IPersonComparator comparator){
        for (int i = list.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(comparator.compare(list[j], list[j+1]) > 0)
                {
                    Person c = list[j];
                    list[j] = list[j+1];
                    list[j+1] = c;
                }
            }
        }
        logger.info(String.format("List sorted with sort: (%s) and comparator: (%s).", BubbleSort.class.getName(), comparator.getClass().getName()));
        return list;
    }
}
