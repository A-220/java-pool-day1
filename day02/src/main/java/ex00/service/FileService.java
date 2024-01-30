package ex00.service;

import java.util.Set;

public interface FileService {
    /**
     * Writes the file type to resources/result.txt
     *
     * @param path Absolute path to any file on your system.
     */
    void writeTypeOfFile(String path);

    /**
     * @param path Absolute path to any file on your system.
     * @return type of file signature or exception if type of
     * this file doesn't exist
     */
    String getFileSignature(String path);

}
