package hod.springframework.spring5webapp.bean.example.playground.lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Util {

    private static List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person("Tich", LocalDate.of(1991, 04, 29), Person.Sex.MALE, "tk@mail.com"));
        personList.add(new Person("Josh", LocalDate.of(1992, 04, 28), Person.Sex.MALE, "jk@mail.com"));
        personList.add(new Person("Kames", LocalDate.of(1993, 04, 27), Person.Sex.MALE, "tj@mail.com"));
        personList.add(new Person("Mizzle", LocalDate.of(1994, 04, 26), Person.Sex.MALE, "jt@mail.com"));
        personList.add(new Person("Kamizzle", LocalDate.of(1995, 04, 25), Person.Sex.MALE, "kt@mail.com"));
    }

    static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function <X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    static List<Person> getPersonList() {
        return personList;
    }

    public static void main(String[] args) {

        Util util = new Util();

        //old way
//        printPersonsOlderThan(getPersonList(), 28);

        //good way
//        printPersons(getPersonList(), new CheckPersonEligibleForSelectiveService());

        //better way
//        printPersons(
//                getPersonList(),
//                new CheckPerson() {
//                    public boolean test(Person p) {
//                        return p.getGender() == Person.Sex.MALE
//                                && p.getAge() >= 18
//                                && p.getAge() <= 25;
//                    }
//                }
//        );

        //best way - lambdas (a start)
//        printPersons(
//                getPersonList(),
//                (Person p) -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25
//        );

        //using generics Predicate<T>
//        printPersonsWithPredicate(
//                getPersonList(),
//                p -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25
//        );

//        processPersons(
//                getPersonList(),
//                p -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                p -> p.printPerson()
//        );

//        processPersonsWithFunction(
//                getPersonList(),
//                p -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                p -> p.getEmailAddress(),
//                email -> System.out.println(email)
//        );

//        processElements(
//                getPersonList(),
//                p -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                p -> p.getEmailAddress(),
//                email -> System.out.println(email)
//        );

        //using aggregate operations
        getPersonList()
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }
}
