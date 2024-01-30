package ex01;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        File firstFile = new File(args[0]);
        File secondFile = new File(args[1]);
        if (sizeInMegaBytes(firstFile) >= 10 || sizeInMegaBytes(secondFile) >= 10) {
            throw new IllegalArgumentException("File cannot be 10 mb or more");
        }
    }

    private static double sizeInMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024);
    }
}
