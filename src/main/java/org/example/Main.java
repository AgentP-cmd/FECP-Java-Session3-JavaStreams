package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> num = List.of(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> isOdd = (s) -> s%2 != 0;

        List<Integer> act1Result = num.stream().filter(isOdd).toList();

        System.out.println("Activity #1");
        System.out.println("Odd Numbers: " + act1Result);


        List<String> names = List.of("Alice", "Adam", "Bob", "Angela", "Brian");

        Predicate<String> startsWithA = (s) -> s.startsWith("A");

        List<String> act2Result = names.stream().filter(startsWithA).toList();

        System.out.println("Activity #2");
        System.out.println("Names Starting with A: " + act2Result);

        List<Integer> act3Result = num.stream().map((s)-> s*s).limit(5).toList();

        System.out.println("Activity #3");
        System.out.println("Squared Numbers: " + act3Result);

        Predicate<Integer> isEven = (s) -> s%2 == 0;
        Predicate<Integer> greaterThanFive = (s) -> s > 5;
        List<Integer> act4Result = num.stream().filter(isEven.and(greaterThanFive)).toList();

        System.out.println("Activity #4");
        System.out.println("Even and > 5: " + act4Result);

        List<Person> people = Arrays.asList(
                new Person("Ben", 20),
                new Person("Mike", 25),
                new Person("Anna", 22),
                new Person("Zara", 29),
                new Person("John", 18)
        );

        System.out.println("Activity #5");
        people.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println("Sorted by age (Ascending): ");
        people.forEach(System.out::println);
        people.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println("Sorted by name: ");
        people.forEach(System.out::println);
        people.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName).reversed());
        System.out.println("Sorted by age (Descending): ");
        people.forEach(System.out::println);
    }
}