package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Завдання 1 ===");
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try { middleName.get(); }
        catch (IllegalStateException ex) { System.out.println("Очікуваний виняток: " + ex.getMessage()); }

        try { new MyOptional<String>(null); }
        catch (IllegalArgumentException ex) { System.out.println("Правильно не дозволив null: " + ex.getMessage()); }

        System.out.println("\n=== Завдання 2 ===");
        BookData b1 = new BookData("Book A", "Author A", 10, 45);
        BookData b2 = new BookData("Book B", "Author B", 5, 25);
        BookData b3 = new BookData("Book C", "Author C", 0, 0);
        BookData[] books = {b1, b2, b3};
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));

        System.out.println("\n=== Завдання 3 ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        System.out.println("\n=== Завдання 4 ===");
        String[] words = {"apple", "banana", "cherry", "date"};
        Predicate<String> pred = s -> s.length() > 5;
        Object[] filteredObj = GenericFilter.filter(words, pred);
        String[] filteredWords = Arrays.copyOf(filteredObj, filteredObj.length, String[].class);
        System.out.println(Arrays.toString(filteredWords));

        System.out.println("\n=== Завдання 5 ===");
        String[] arr = {"one","two","three"};
        System.out.println(GenericContains.contains(arr,"two")); // true
        System.out.println(GenericContains.contains(arr,"four")); // false

        System.out.println("\n=== Завдання 6 ===");
        GenericTwoTuple<String,Integer> tuple = new GenericTwoTuple<>("Alice", 90);
        System.out.println(tuple);
        GenericThreeTuple<String,Integer,Double> triple = new GenericThreeTuple<>("Bob", 85, 4.5);
        System.out.println(triple);
    }
}

