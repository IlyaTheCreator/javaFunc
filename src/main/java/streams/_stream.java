package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._stream.Gender.MALE;

public class _stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
////                .collect(Collectors.toSet())
//                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
//                .allMatch(person -> Gender.FEMALE.equals(person.gender));
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));
    }

    static class Person {
        private final String name;
        public final Gender gender;

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
    }

//    static class IsMale implements Predicate<Person> {
//        @Override
//        public boolean test(Person person) {
//            return MALE.equals(person.gender);
//        }
//    }

    enum Gender {
        MALE, FEMALE
    }
}
