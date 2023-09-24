package io.github.wesleyosantos91.jep443;

record Person(String name, String lastName) { }

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Wesley", "Oliveira Santos");

        // As of Java 21 Unnamed Patterns and Variables
        // Unnamed variables are useful in scenarios where a variable must be declared, but its value is not used.
        if (person instanceof Person(String name, _)) {
            System.out.println(STR."Hello my name is \{name}");
        }
    }
}
