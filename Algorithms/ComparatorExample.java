import java.io.*;
import java.util.*;

class ComparatorExample{
	public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Joe", 24),
                new Person("Pete", 18),
                new Person("Chris", 21)
        );
        Collections.sort(people, new LexicographicComparator());
        System.out.println(people);
        Collections.sort(people, idComparater);
        System.out.println(people);
    }

    // Sort by name
    static class LexicographicComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return a.name.compareToIgnoreCase(b.name);
        }
    }
    // Sort by age
    static class AgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return (int)a.age-b.age;
        }
    }

    // Another way to initialize a comparator 
    public static Comparator<Person> idComparater=new Comparator<Person>(){
        @Override
        public int compare(Person c1, Person c2){
            return (int)(c1.age-c2.age);
        }
    };

    static class Person {
        String name;
        int age;
        public Person(String n, int a) {
            name = n;
            age = a;
        }
        @Override
        public String toString() {
            return String.format("{name=%s, age=%d}", name, age);
        }
    }
}

