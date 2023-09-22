# Novas Fetures Java 21
## JEP 430: String Templates (Preview)
> Os novos 'templates' de strings aprimoram a linguagem de programação Java, permitindo a criação de strings formatadas de maneira mais flexível e eficiente. Com essa funcionalidade, é possível combinar texto literal com expressões embutidas e processadores de templates para produzir resultados especializados, tornando o desenvolvimento em Java ainda mais poderoso e intuitivo.
### [Documentação Oficial](https://openjdk.org/jeps/430)
### Exemplo

```java
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

````

## JEP 431: Sequenced Collections

> Essa atualização tem inclusão de interfaces adicionais que tem objetivo representar collections que mantêm uma ordem de encontro específica. Cada uma dessas coleções oferece acesso claro ao seu primeiro e último elemento, bem como a capacidade de processar seus elementos na ordem inversa, enriquecendo a flexibilidade e utilidade das estruturas de dados em Java.
### [Documentação Oficial](https://openjdk.org/jeps/431)
### Exemplo

```java
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

````

## JEP 445: Unnamed Classes and Instance Main Methods (Preview)
> Essa atualização visa simplificar a programação em Java para estudantes, permitindo que eles comecem a escrever programas sem a necessidade de dominar recursos complexos da linguagem.
### [Documentação Oficial](https://openjdk.org/jeps/445)
### Exemplo

```java
void main(String[] args) {
    System.out.println("Olá mundo!");
}
````