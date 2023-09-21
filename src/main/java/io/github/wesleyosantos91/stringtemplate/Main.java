package io.github.wesleyosantos91.stringtemplate;

public class Main {

    public static void main(String[] args) {
        var name = "wesley";
        String[] lastName = {"Oliveira", "Santos"};

        // old
        String exemple1 = "Hello my full name is " + name + " " + lastName[0] + " " + lastName[1];
        System.out.println(exemple1);
        // new feature java 21
        String stringTemplateExemple1 = STR."Hello my full name is \{name} \{lastName[0]} \{lastName[1]}";
        System.out.println(stringTemplateExemple1);

        //old
        String exemple2 =
                STR."""
                    SELECT *
                    FROM person p
                WHERE p.name = \'%s\'
                    """.formatted(name);
        System.out.println(exemple2);
        // new feature java 21
        String stringTemplateExemple2 =
                STR."""
                    SELECT *
                    FROM person p
                WHERE p.name = \'\{name}\'
                    """;
        System.out.println(stringTemplateExemple2);
    }
}
