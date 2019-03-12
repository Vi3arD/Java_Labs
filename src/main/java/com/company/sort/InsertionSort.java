package com.company.sort;


import com.company.comparator.IPersonComparator;
import com.company.models.Person;
import org.apache.log4j.Logger;

//класс предназначенный для сортровки списка элементов, состоящих из объектов класса Person
//посредством использования сортровки вставками
public class InsertionSort implements IPersonSort{

    private static final Logger logger = Logger.getLogger(InsertionSort.class);

    public Person[] sort(Person[] list, IPersonComparator comparator)
    {
        Person temp;
        int j;
        for(int i = 0; i < list.length - 1; i++){
            if (comparator.compare(list[i], list[i+1]) > 0) {
                temp = list[i + 1];
                list[i + 1] = list[i];
                j = i;
                while (j > 0 && comparator.compare(temp, list[j-1]) < 0) {
                    list[j] = list[j - 1];
                    j--;
                }
                list[j] = temp;
            }
        }
        logger.info(String.format("List sorted with sort: (%s) and comparator: (%s).", InsertionSort.class.getName(), comparator.getClass().getName()));
        return list;
    }
}
