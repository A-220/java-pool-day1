package ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weekNum = 1;
        String week;
        StringBuilder result = new StringBuilder();

        while (true) {
            System.out.print("-> ");
            week = scanner.nextLine();

            if ("42".equals(week) || weekNum > 18) {
                break;
            }

            String expectedWeek = "Week " + weekNum;
            if (!week.equals(expectedWeek)) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }

            int count = 0;
            int min = 9;

            System.out.print("-> ");
            String res = scanner.nextLine();
            for (int i = 0; i < res.length(); ++i) {
                char ch = res.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int num = ch - '0';
                    if (num < min) {
                        min = num;
                    }
                    ++count;
                } else if (ch != ' ') {
                    System.out.println("IllegalArgument");
                    System.exit(-1);
                }

                if (count > 5) {
                    System.out.println("IllegalArgument");
                    System.exit(-1);
                }
            }

            result.append(min);
            weekNum++;
        }

        for (int i = 0; i < result.length(); i++) {
            System.out.print("Week " + (i + 1) + " ");
            int length = result.charAt(i) - '0'; // Преобразуем символ в цифру

            for (int j = 0; j < length; ++j) {
                System.out.print("=");
            }
            System.out.println(">");
        }

        scanner.close();
    }
}

