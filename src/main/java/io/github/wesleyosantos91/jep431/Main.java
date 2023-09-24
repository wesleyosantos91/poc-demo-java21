package io.github.wesleyosantos91.jep431;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> fruits = List.of("apples", "oranges", "peaches");
        LinkedHashSet<String> colors = new LinkedHashSet<>(Arrays.asList("blue", "green", "red"));

        // Prior to Java 21 get the first element
        System.out.println(fruits.get(0));
        // As of Java 21 get the first element
        System.out.println(fruits.getFirst());

        // Prior to Java 21 get the last element
        System.out.println(fruits.get(fruits.size()-1));
        // As of Java 21 get the last element
        System.out.println(fruits.getLast());

        // Prior to Java 21 get the first element
        System.out.println(colors.iterator().next());
        // As of Java 21 get the first element
        System.out.println(colors.getFirst());

        // Prior to Java 21 get the last element or convert to list and used previous exemple
        String lastElement = null;
        for (String color : colors) {
            lastElement = color;
        }
        System.out.println(lastElement);

        // As of Java 21 get the last element
        System.out.println(colors.getLast());

        // As of Java 21 reverse order colletions
        System.out.println(fruits.reversed());
        System.out.println(colors.reversed());

    }
}
