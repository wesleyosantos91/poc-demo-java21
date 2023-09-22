package io.github.wesleyosantos91.sequenced;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> fruits = List.of("apples", "oranges", "peaches");
        LinkedHashSet<String> colors = new LinkedHashSet<>(Arrays.asList("blue", "green", "red"));

        // old get the first element
        System.out.println(fruits.get(0));
        // new feature java 21 get the first element
        System.out.println(fruits.getFirst());

        // old get the last element
        System.out.println(fruits.get(fruits.size()-1));
        // new feature java 21 get the last element
        System.out.println(fruits.getLast());

        // old get the first element
        System.out.println(colors.iterator().next());
        // new feature java 21 get the first element
        System.out.println(colors.getFirst());

        // old get the last element or convert to list and used previous exemple
        String lastElement = null;
        for (String color : colors) {
            lastElement = color;
        }
        System.out.println(lastElement);

        // new feature java 21 get the last element
        System.out.println(colors.getLast());

        // new feature java 21 reverse order colletions
        System.out.println(fruits.reversed());
        System.out.println(colors.reversed());

    }
}
