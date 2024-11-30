package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> arrayList = new ArrayList<>();

        for(int i = 1; i <= 10; i++){
            Random random = new Random();
            int randomValue = random.nextInt(1,100 - 1);
            arrayList.add(randomValue);
        }

        // Call methods
    }

    public static void separateOddEven(List<Integer> list){
        list.stream().collect(Collectors.partitioningBy(num -> num % 2 ==0));
    }

    public static void removeDuplicates(List<Integer> list){
        list.stream().distinct().collect(Collectors.toList());
    }

    public static void frequencyOfEachCharacter(String inputString){
        inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void frequencyOfEachElementInArray(List<Integer> list){
        list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public static void sortInReverseOrder(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static void printMultipleOf5(List<Integer> list){
        list.stream().filter(num -> num % 5 == 0).collect(Collectors.toList());
    }

    public static void mergeTwoUnsortedArray(int[] l1, int[] l2){
        IntStream.concat(Arrays.stream(l1), Arrays.stream(l2)).sorted().forEach(System.out::println);
    }

    public static void mergeTwoUnsortedArrayWithoutDuplicate(int[] l1, int[] l2){
        IntStream.concat(Arrays.stream(l1), Arrays.stream(l2)).sorted().distinct().forEach(System.out::println);
    }

    public static void threeMaxMinFromList(List<Integer> list){
        list.stream().sorted().limit(3).forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }

    public static void sortIncreasingOrderOfString(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    public static void sumAndAverage(List<Integer> list){
        list.stream().mapToInt(Integer::intValue).sum();
        list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public static void maxMin(List<Integer> list){
        list.stream().max(Comparator.naturalOrder()).get();
        list.stream().min(Comparator.naturalOrder()).get();

        list.stream().sorted().limit(1).forEach(System.out::println);
    }

    public static void stringsWhichStartWithNumber(List<String> list){
        list.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);
    }

    public static void sumOfAllDigitsOfNumber(int number){
        Stream.of(String.valueOf(number)
                .split(""))
                .collect(Collectors.summingInt(Integer::parseInt));
    }
}