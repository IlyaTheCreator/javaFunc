package imperative;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );

        System.out.println("imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("declarative approach");

        Predicate<Person> predicate = person -> FEMALE.equals(person.gender);
        Predicate<Person> isMale = new IsMale();

        List<Person> females2 = people.stream()
                .filter(isMale)
                .collect(Collectors.toList());

        // the double colon syntax is called method reference
        // method references are treated the same way lambda expressions
        // are, but instead of providing a lambda body they refer to an
        // existing method by name


        List<Person> females3 = people.stream()
                //.sorted((Person p1, Person p2) -> p1.getName().compareTo(p2.getName()))
                // .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        females2.forEach(System.out::println);

    }

    public static class Person {
        private final String name;
        private final Gender gender;

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public Gender getGender() {
            return gender;
        }
    }

    static class IsMale implements Predicate<Person> {
        @Override
        public boolean test(Person person) {
            return MALE.equals(person.gender);
        }
    }

    public enum Gender {
        MALE, FEMALE
    }
}
