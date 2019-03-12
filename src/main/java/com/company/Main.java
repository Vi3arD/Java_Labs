package com.company;

import com.company.collection.PersonListOur;
import com.company.models.Person;
import org.joda.time.DateTime;

public class Main {

    public static void main(String[] args) {

        PersonListOur p = new PersonListOur();

        p.addPerson(new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male));
        p.addPerson(new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male));
        p.addPerson(new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female));
        p.addPerson(new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female));
        System.out.println(p.toString());

        PersonListOur l1 = p.searchByName("p2");
        System.out.println(l1.toString());

        PersonListOur l2 = p.searchByAge(19);
        System.out.println(l2.toString());

        PersonListOur l3 = p.searchByDateOfBirth(new DateTime(2010, 5, 15, 0,0));
        System.out.println(l3.toString());

        p.sortByAge();
        System.out.println(p.toString());

        p.sortByName();
        System.out.println(p.toString());

        p.sortByDateOfBirth();
        System.out.println(p.toString());

        System.out.println("---end---");

    }
}
