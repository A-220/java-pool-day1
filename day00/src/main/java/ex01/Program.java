package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int number = scanner.nextInt();
        scanner.close();

        if (number <= 1) {
            System.out.println("Illegal Argument");
            System.exit(-1);
        }

        boolean isPrime = true;
        int count = 0;

        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
            count++;
        }

        if (isPrime && number > 2) {
            count++;
        }

        System.out.println(isPrime + " " + count);
    }
}

