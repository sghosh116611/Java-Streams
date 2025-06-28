package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Pratice {

    public static void main(String[] args) {
        System.out.println("Filter Even Numbers - Given a list of integers, return a list containing only even numbers.");
        filterEven(Arrays.asList(2, 3, 4, 6, 1, 9)).forEach(System.out::println);

        System.out.println("Uppercase Conversion - Given a list of strings, return a list with each string converted to uppercase.");
        upperCaseConversion(Arrays.asList("abc", "Acd", "AVD")).forEach(System.out::println);

        System.out.println("Count Empty Strings - Count how many strings in a list are empty.");
        System.out.println(countEmptyString(Arrays.asList("", "   ", "a", "abc", " ")));

        System.out.println("Square Numbers - Given a list of integers, return a list with the square of each number.");
        squareOfEachNumber(Arrays.asList(2, 3, 4, 6, 10, 9)).forEach(System.out::println);

        System.out.println("Find First Matching Element - Given a list of strings, find the first string that starts with the letter \"A\". Return \"Not found\" if none exist.");
        System.out.println(firstStringThatStartsWithA(Arrays.asList("abc", "Abs", "Axz")));

        System.out.println("Frequency - Given a list of strings, return a map showing the frequency of each string.");
        frequencyOfEachString(Arrays.asList("Soumo", "Soumo", "James", "james")).forEach((key, value) -> System.out.println(key + "->" + value));

        System.out.println("Longest Word - Given a list of strings, find the longest word. If multiple words have the same length, return any.");
        System.out.println(longestWordInList(Arrays.asList("abcduwmsma", "x")));

        System.out.println("Join with Comma - Given a list of strings, join them into a single comma-separated string.");
        System.out.println(joinListWithComma(Arrays.asList("soumo", "raju", "shyam", "baburao")));

        System.out.println("Group People by Age - Given a list of Person objects (name, age), group people by age.");
        groupPeopleByAge(Arrays.asList(new People("Soumo", 26), new People("Raju", 25), new People("Jitu", 25)))
                .forEach((key, peopleList) -> System.out.println(key + "->" +
                        peopleList.stream()
                                .map(people -> people.name)
                                .collect(Collectors.joining(",")
                                )));

        System.out.println("Sort List of People by Name, then Age - Given a list of Person(name, age), sort by name, then by age (ascending)");
        sortByNameAge(Arrays.asList(new People("Soumo", 26), new People("Soumo", 27), new People("Raju", 25), new People("Jitu", 25)))
                .forEach(people -> System.out.println(people.name + "->" + people.age));

        System.out.println("Group People by Age - Given a list of Person objects (name, age), group people by age.");
        groupPeopleByAgeRange(Arrays.asList(new People("Soumo", 10), new People("Raju", 20), new People("Shyam", 25), new People("Babu Rao", 85)))
                .forEach((age, peopleList) -> System.out.println(age + "->" + peopleList.stream().map(people -> people.name).collect(Collectors.joining(","))));

        System.out.println("Yearly Event Count - Given a list of Event objects with a LocalDate field, return a map of year to count of events that occurred in that year (sorted by year).");
        groupByDateAndCount(Arrays.asList(new Event("Event 1", LocalDate.parse("2025-01-01")), new Event("Event 2", LocalDate.parse("2025-02-01")),
                new Event("Event 3", LocalDate.parse("2025-01-01")))).forEach((date, count) -> System.out.println(date + "->" + count));

        System.out.println("Get Distinct Characters From All Words - Given a list of words, return a list of all distinct characters across all words.");
        distinctCharactersForEachWord(Arrays.asList("Java", "Stream", "API")).forEach(System.out::println);

        System.out.println("Count Word Frequency Case-Insensitive");
        countFreqCaseInsensitive(Arrays.asList("Soumo", "soumo", "soUmO", "raju", "Raju")).forEach((key, count) -> System.out.println(key + "->" + count));

    }

    //Filter Even Numbers - Given a list of integers, return a list containing only even numbers.
    private static List<Integer> filterEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    //Uppercase Conversion - Given a list of strings, return a list with each string converted to uppercase.
    private static List<String> upperCaseConversion(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //Count Empty Strings - Count how many strings in a list are empty ("").
    private static long countEmptyString(List<String> list) {
        return list.stream()
                .filter(String::isBlank)
                .count();
    }

    //Square Numbers - Given a list of integers, return a list with the square of each number.
    private static List<Integer> squareOfEachNumber(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    //Find First Matching Element - Given a list of strings, find the first string that starts with the letter "A". Return "Not found" if none exist.
    private static String firstStringThatStartsWithA(List<String> list) {
        return list.stream()
                .filter(s -> s.charAt(0) == 'A')
                .findFirst()
                .orElse("Not Found");
    }

    //Frequency - Given a list of strings, return a map showing the frequency of each string.
    private static Map<String, Long> frequencyOfEachString(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    //Longest Word - Given a list of strings, find the longest word. If multiple words have the same length, return any.
    private static String longestWordInList(List<String> list) {
        return list.stream()
                .max(Comparator.comparingInt(String::length))
                .stream().findFirst().orElse("No word");
    }

    //Join with Comma - Given a list of strings, join them into a single comma-separated string.
    private static String joinListWithComma(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(","));
    }

    static class People {
        String name;
        int age;

        People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    //Group People by Age - Given a list of Person objects (name, age), group people by age.
    private static Map<Integer, List<People>> groupPeopleByAge(List<People> peopleList) {
        return peopleList.stream()
                .collect(Collectors.groupingBy(people -> people.age));
    }

    //Sort List of People by Name, then Age - Given a list of Person(name, age), sort by name, then by age (ascending).
    private static List<People> sortByNameAge(List<People> peopleList) {
        return peopleList.stream()
                .sorted(Comparator.comparing((People people) -> people.name).thenComparing(people -> people.age))
                .collect(Collectors.toList());
    }

    //Group People by Age Range
    private static Map<String, List<People>> groupPeopleByAgeRange(List<People> list) {
        return list.stream()
                .collect(Collectors.groupingBy(person -> {
                    if (person.age < 18) return "Youth";
                    else if (person.age <= 60) return "Adult";
                    else return "Senior";
                }));
    }

    //Yearly Event Count - Given a list of Event objects with a LocalDate field, return a map of year to count of events that occurred in that year (sorted by year).
    static class Event {
        String eventName;
        LocalDate date;

        Event(String eventName, LocalDate date) {
            this.eventName = eventName;
            this.date = date;
        }
    }

    private static Map<LocalDate, Long> groupByDateAndCount(List<Event> eventList) {
        return eventList.stream()
                .collect(Collectors.groupingBy(event -> event.date, Collectors.counting()));
    }

    //Get Distinct Characters From All Words - Given a list of words, return a list of all distinct characters across all words.
    private static List<String> distinctCharactersForEachWord(List<String> list) {
        return list.stream()
                .flatMap(str -> str.chars().mapToObj(s -> String.valueOf((char) s)))
                .distinct()
                .collect(Collectors.toList());
    }

    //Partition Numbers Into Even and Odd -  Given a list of integers, partition them into even and odd.
    private static Map<Boolean, List<Integer>> separateEvenAndOdd(List<Integer> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
    }

    //Count Word Frequency Case-Insensitive
    private static Map<String, Long> countFreqCaseInsensitive(List<String> list) {
        return list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}


