package ex04;

import java.util.Scanner;

public class Program {
    private static final int MAX = Character.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        if (input.length() > 999) {
            System.out.println("Illegal Argument");
            System.exit(-1);
        }
        int[] arr = new int[MAX];
        char[] charArr = input.toCharArray();

        for (char c : charArr)
            ++arr[c];

        char tmpChar = Character.MIN_VALUE;
        int tmpCount = 0;
        int position = 0;
        char[] charsArray = new char[10];
        int[] numsArray = new int[10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < Character.MAX_VALUE; j++) {
                if (arr[j] == 0) continue;
                if (arr[j] > tmpCount) {
                    tmpCount = arr[j];
                    tmpChar = (char) j;
                    position = j;
                }
            }
            numsArray[i] = arr[position];
            charsArray[i] = tmpChar;
            arr[position] = 0;
            tmpChar = Character.MIN_VALUE;
            tmpCount = 0;
        }


        int max = numsArray[0];
        for (int count : numsArray) {
            if (count == max) {
                System.out.println(max + "    ");
            }
        }
        for (int i = 10; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (numsArray[j] * 10 / max >= i)
                    System.out.print("#   ");
                if (numsArray[j] * 10 / max == i - 1) {
                    if (numsArray[j] != 0) System.out.print(numsArray[j] + "   ");
                }
            }
            System.out.println();
        }
        for (char ch : charsArray) {
            System.out.print(ch + "   ");
        }
    }
}
