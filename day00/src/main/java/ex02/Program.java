package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int input = scanner.nextInt();
        int res = 0;
        while (input != 42) {
            int cashResult = 0;
            int cashInput = input;
            boolean isPrime = true;
            while (cashInput > 0) {
                cashResult += cashInput % 10;
                cashInput /= 10;
            }
            if (cashResult <= 1) {
                isPrime = false;
            }
            if (cashResult % 2 == 0) {
                isPrime = false;
            }
            for (int i = 3; i < Math.sqrt(cashResult); i++) {
                if (cashResult % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                res++;
            }
            System.out.print("-> ");
            input = scanner.nextInt();
        }
        System.out.printf("Count of coffee-request - %s", res);
        scanner.close();
    }
}
