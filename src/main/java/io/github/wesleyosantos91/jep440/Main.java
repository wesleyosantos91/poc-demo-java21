package io.github.wesleyosantos91.jep440;

record Person(String name, String lastName) { }

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Wesley", "Oliveira Santos");

        // Prior to Java 21 pattern matching for Record
        if (person instanceof Person p) {
            System.out.println(STR."Hello my full name is \{p.name()} \{p.lastName()}");
        }

        // As of Java 21 Record Patterns (destructuring)
        if (person instanceof Person(String name, String lastName)) {
            System.out.println(STR."Hello my full name is \{name} \{lastName}");
        }
    }
}
