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


## JEP 445: Unnamed Classes and Instance Main Methods (Preview)
> Essa atualização visa simplificar a programação em Java para estudantes, permitindo que eles comecem a escrever programas sem a necessidade de dominar recursos complexos da linguagem.
### [Documentação Oficial](https://openjdk.org/jeps/445)
### Exemplo

```java
void main(String[] args) {
    System.out.println("Olá mundo!");
}
````