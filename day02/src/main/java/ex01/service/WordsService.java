package ex01.service;

import java.util.List;
import java.util.Set;

public interface WordsService {
    List<String> readFile(String path);

    Set<String> findUniqWords(List<String> first, List<String> second);

    List<Integer> findRepetitionRate(Set<String> uniqWords, List<String> words);

    Double findSimilarity(List<Integer> fistVector, List<Integer> secondVector);
    Double getSimilarity(String firstFilePath, String secondFilePath);

}
