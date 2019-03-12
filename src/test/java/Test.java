import com.company.collection.PersonListOur;
import com.company.comparator.PersonAgeComparator;
import com.company.comparator.PersonDateOfBirthComparator;
import com.company.comparator.PersonNameComparator;
import com.company.models.Person;
import com.company.sort.BubbleSort;
import com.company.sort.InsertionSort;
import com.company.sort.SelectionSort;
import org.joda.time.DateTime;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void testSearchByAge()
    {
        PersonListOur p = new PersonListOur();

        p.addPerson(new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male));
        p.addPerson(new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male));
        p.addPerson(new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female));
        p.addPerson(new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female));
        p.addPerson(new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female));

        PersonListOur expected = new PersonListOur();
        expected.addPerson(p.getById(0));

        PersonListOur pp = p.searchByDateOfBirth(new DateTime(2000, 5, 12, 0,0));

        assertEquals(pp.getById(0), expected.getById(0));

        int bp = 0;
    }

    @org.junit.Test
    public void testSearchByName()
    {
        PersonListOur p = new PersonListOur();

        p.addPerson(new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male));
        p.addPerson(new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male));
        p.addPerson(new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female));
        p.addPerson(new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female));
        p.addPerson(new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female));

        PersonListOur expected = new PersonListOur();
        expected.addPerson(p.getById(2));

        PersonListOur pp = p.searchByName("p3");

        assertEquals(pp.getById(0), expected.getById(0));

        int bp = 0;
    }

    @org.junit.Test
    public void testSelectionSortByName()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new SelectionSort().sort(p, new PersonNameComparator());
        Arrays.sort(p, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testSelectionSortByAge()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new SelectionSort().sort(p, new PersonAgeComparator());
        Arrays.sort(p, (o1, o2) -> o1.getAge() - (o2.getAge()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testSelectionSortByDateOfBirth()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new SelectionSort().sort(p, new PersonDateOfBirthComparator());
        Arrays.sort(p, (o1, o2) -> -o1.getDateOfBirth().compareTo(o2.getDateOfBirth()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testInsertionSortByName()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new InsertionSort().sort(p, new PersonNameComparator());
        Arrays.sort(p, (o1, o2) -> p1.getName().compareTo(p2.getName()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testInsertionSortByAge()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new InsertionSort().sort(p, new PersonAgeComparator());
        Arrays.sort(p, (o1, o2) -> o1.getAge() - (o2.getAge()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testInsertionSortByDateOfBirth()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new InsertionSort().sort(p, new PersonDateOfBirthComparator());
        Arrays.sort(p, (o1, o2) -> -o1.getDateOfBirth().compareTo(o2.getDateOfBirth()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testBubbleSortByName()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new BubbleSort().sort(p, new PersonNameComparator());
        Arrays.sort(p, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testBubbleSortByDateOfBirth()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new BubbleSort().sort(p, new PersonDateOfBirthComparator());
        Arrays.sort(p, (o1, o2) -> -o1.getDateOfBirth().compareTo(o2.getDateOfBirth()));
        assertEquals(p, expected);

        int bp = 0;
    }

    @org.junit.Test
    public void testBubbleSortByAge()
    {
        Person  p1 = new Person("p1", new DateTime(2000, 5, 12, 0,0), Person.Sex.Male);
        Person  p2 = new Person("p2", new DateTime(1970, 5, 13, 0,0), Person.Sex.Male);
        Person  p3 = new Person("p3", new DateTime(1980, 5, 14, 0,0), Person.Sex.Female);
        Person  p4 = new Person("p4", new DateTime(2010, 5, 15, 0,0), Person.Sex.Female);
        Person  p5 = new Person("p4", new DateTime(2015, 5, 16, 0,0), Person.Sex.Female);

        Person[] p = new Person[]{p1, p2, p3, p4, p5};
        Person[] expected = new BubbleSort().sort(p, new PersonAgeComparator());
        Arrays.sort(p, (o1, o2) -> o1.getAge() - (o2.getAge()));
        assertEquals(p, expected);

        int bp = 0;
    }

}
