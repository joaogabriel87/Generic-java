package Exercicios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberPrimoFatorPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println("Primo numero: " + number);
        } else{
            System.out.println(number + " Não é primo");
            Set<Integer> fatoresPrimos = obterFatPrimos(number);
            System.out.println("Fatores primos: " + fatoresPrimos);
        }


    }

    public static boolean isPrime(int number) {
        if(number <= 1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static Set<Integer> obterFatPrimos(int n){
        Set<Integer> fatores = new HashSet<>();
        int divisor = 2;

        while(n > 1){
            if(n % divisor ==0){
                fatores.add(n);
                n/=divisor;
            } else{
                divisor++;
            }
        }
        return fatores;
    }
}
