# Novas Fetures Java 21
## JEP 430: String Templates (Preview)
> Os novos 'templates' de strings aprimoram a linguagem de programação Java, permitindo a criação de strings formatadas 
> de maneira mais flexível e eficiente. Com essa funcionalidade, é possível combinar texto literal com expressões 
> embutidas e processadores de templates para produzir resultados especializados, tornando o desenvolvimento em Java 
> ainda mais poderoso e intuitivo.
### [Documentação Oficial](https://openjdk.org/jeps/430)
### Exemplo

```java
package io.github.wesleyosantos91.jep430;

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
> Essa atualização tem inclusão de interfaces adicionais que tem objetivo representar collections que mantêm uma ordem 
> de encontro específica. Cada uma dessas coleções oferece acesso claro ao seu primeiro e último elemento, bem como a 
> capacidade de processar seus elementos na ordem inversa, enriquecendo a flexibilidade e utilidade das 
> estruturas de dados em Java.
### [Documentação Oficial](https://openjdk.org/jeps/431)
### Exemplo

```java
package io.github.wesleyosantos91.jep431;

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
        System.out.println(fruits.get(fruits.size() - 1));
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

## JEP JEP 439: ZGC Geracional
> O ZGC Geracional herda as capacidades do Z Garbage Collector (ZGC), introduzindo gerações separadas para objetos 
> novos e antigos, permitindo ao ZGC coletar objetos novos mais frequentemente, o que é especialmente benéfico, 
> pois eles têm ciclos de vida mais curtos. Para habilitar o ZGC Geracional, você pode adicionar a 
> opção ```-XX:+ZGenerational``` ao usar o ZGC no comando, como em ```java -XX:+UseZGC -XX:+ZGenerational```. 
> Essa mudança promete menor latência, redução na sobrecarga de memória e uso de CPU reduzido, sem afetar 
> significativamente o throughput em comparação com o non-generational ZGC. Esta é uma ótima notícia para o ecossistema 
> Java, e o ZGC Geracional está no caminho certo para se tornar a escolha padrão em futuras versões, oferecendo 
> benefícios substanciais para aplicativos Java em todo o mundo.
### [Documentação Oficial](https://openjdk.org/jeps/439)
### Exemplo

```shell
javac Main.java
java -XX:+UseZGC -XX:+ZGenerational Main
````

## JEP 440: Record Patterns
> Aprimorar a linguagem de programação Java com Record Patterns para descontruir valores de registro é uma proposta 
> empolgante. Essa adição possibilitaria uma forma mais poderosa, declarativa e componível de navegar e processar dados. 
> Inspirada em conceitos de outras linguagens de programação, essa melhoria tornaria o código Java mais elegante e 
> eficiente, permitindo aos desenvolvedores aproveitar a facilidade de uso e a legibilidade dos Record Patterns e de 
> tipo aninhados. Essa evolução na linguagem Java abriria novas possibilidades para a manipulação de dados e 
> contribuiria para uma programação mais expressiva e concisa.
### [Documentação Oficial](https://openjdk.org/jeps/440)
### Exemplo
```java
package io.github.wesleyosantos91.jep440;

record Person(String name, String lastName) { }

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Wesley", "Oliveira Santos");

        // old pattern matching for Record
        if (person instanceof Person p) {
            System.out.println(STR."Hello my full name is \{p.name()} \{p.lastName()}");
        }

        // new feature java 21 Record Patterns (destructuring)
        if (person instanceof Person(String name, String lastName)) {
            System.out.println(STR."Hello my full name is \{name} \{lastName}");
        }
    }
}

```

## JEP 441: Pattern Matching for switch
> A adição da pattern matching para expressões e instruções do tipo switch no Java representa uma 
> funcionalidade que permite que você teste uma expressão em relação a vários padrões, cada um com ações específicas 
> associadas. Isso torna mais fácil e conciso lidar com situações complexas relacionadas a dados. Essa melhoria permite 
> que os desenvolvedores expressem consultas e manipulações de dados de forma mais direta e segura, simplificando o 
> código e melhorando a legibilidade. Em resumo, essa feature amplia a capacidade do Java de processar e manipular dados
> de maneira mais eficaz e expressiva.
> 
> Obs: Essa funcionalidade foi lançada inicialmente como preview no java 17 (JEP 406: Pattern Matching for switch (Preview)
> e posteriomente pelas: 
> - JEP 427: Pattern Matching for switch (Third Preview)
> - JEP 432: Record Patterns (Second Preview)
> - JEP 441: Pattern Matching for switch (final version) 

### [Documentação Oficial](https://openjdk.org/jeps/441)
### Exemplo
```java
package io.github.wesleyosantos91.jep441;

public class Main {

    public static void main(String[] args) {
        Integer number = 21;
        System.out.println(formatter(number));
        System.out.println(formatterPatternSwitch(number));
    }

    // Prior to Java 21
    static String formatter(Object obj) {
        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    // As of Java 21
    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> obj.toString();
        };
    }
}

```

## JEP 442: Foreign Function & Memory API (Third Preview)
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/442)
### Exemplo
```java
    // TODO
```

## JEP 443: Unnamed Patterns and Variables (Preview)
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/443)
### Exemplo
```java
    // TODO
```

## JEP 444: Virtual Threads
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/444)
### Exemplo
```java
    // TODO
```

## JEP 445: Unnamed Classes and Instance Main Methods (Preview)
> Essa atualização visa simplificar a programação em Java para estudantes, permitindo que eles comecem a escrever 
> programas sem a necessidade de dominar recursos complexos da linguagem.
### [Documentação Oficial](https://openjdk.org/jeps/445)
### Exemplo

```java
void main(String[] args) {
    System.out.println("Olá mundo!");
}
````

```shell
javac -- release 21 --enable-preview Main.java
java --eneble-preview Main
````

## JEP 446: Scoped Values (Preview)
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/446)
### Exemplo
```java
    // TODO
```

## JEP 448: Vector API (Sixth Incubator)
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/448)
### Exemplo
```java
    // TODO
```

## JEP 449: Deprecate the Windows 32-bit x86 Port for Removal
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/449)
### Exemplo
```java
    // TODO
```

## JEP 451: Prepare to Disallow the Dynamic Loading of Agents
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/451)
### Exemplo
```java
    // TODO
```

## JEP 452: Key Encapsulation Mechanism API
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/452)
### Exemplo
```java
    // TODO
```

## JEP 453: Structured Concurrency (Preview)
> // TODO
### [Documentação Oficial](https://openjdk.org/jeps/453)
### Exemplo
```java
    // TODO
```
