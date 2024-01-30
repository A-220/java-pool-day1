package ex00.util;

import java.io.File;

public class PathUtil {
    public static String getPathToSignal() {
        return new StringBuilder(getPathToResources())
                .append(File.separator)
                .append("signatures.txt").toString();
    }

    public static String getPathToResult() {
        return new StringBuilder(getPathToResources())
                .append(File.separator)
                .append("result.txt").toString();
    }

    public static String getPathToPng() {
        return new StringBuilder(getPathToResources())
                .append(File.separator)
                .append("anime.jpeg").toString();
    }

    public static String getPathToResources() {
        return new StringBuilder(System.getProperty("user.dir")).append(File.separator)
                .append("day02").append(File.separator)
                .append("src").append(File.separator)
                .append("main").append(File.separator)
                .append("resources").toString();
    }
}
