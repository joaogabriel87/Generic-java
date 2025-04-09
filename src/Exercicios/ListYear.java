package Exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListYear {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Joao", 22));
        people.add(new Person("Gabriel", 18));
        people.add(new Person("Oliveira", 64));

        people.forEach(System.out::println);
        Collections.sort(people);

        System.out.println("Ordernada por Comparable");
        people.forEach(System.out::println);

    }

    public static class Person implements Comparable<Person> {


        private String nome;
        private int idade;

        public Person(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public String toString() {
            return
                    "nome='" + nome + '\'' +
                    ", idade=" + idade;
        }

        @Override
        public int compareTo(Person o) {
            return this.idade - o.idade;
        }
    }
}
