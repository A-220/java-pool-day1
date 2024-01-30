package ex01.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordServiceImpl implements WordsService {

    @Override
    public Double getSimilarity(String firstFilePath, String secondFilePath) {
        List<String> firstWords = readFile(firstFilePath);
        List<String> secondWords = readFile(secondFilePath);
        Set<String> uniqWords = findUniqWords(firstWords, secondWords);
        List<Integer> firstVector = findRepetitionRate(uniqWords, firstWords);
        List<Integer> secondVector = findRepetitionRate(uniqWords, secondWords);
        return findSimilarity(firstVector, secondVector);
    }

    @Override
    public List<String> readFile(String path) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                for (String word : br.readLine().split(" ")) {
                    wordsList.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordsList;
    }

    @Override
    public Set<String> findUniqWords(List<String> first, List<String> second) {
        Set<String> uniqWords = new LinkedHashSet<>();
        uniqWords.addAll(first);
        uniqWords.addAll(second);
        return uniqWords;
    }


    @Override
    public List<Integer> findRepetitionRate(Set<String> uniqWords, List<String> words) {
        List<Integer> repetitionRateOfUniqWords = new ArrayList<>();
        for (String uniqWord : uniqWords) {
            int count = 0;
            for (String word : words) {
                if (word.equals(uniqWord)) {
                    count++;
                }
            }
            repetitionRateOfUniqWords.add(count);
        }
        return repetitionRateOfUniqWords;
    }

    @Override
    public Double findSimilarity(List<Integer> firstVector, List<Integer> secondVector) {
        double numerator = 0.0;
        double denominatorFirst = 0.0;
        double denominatorSecond = 0.0;

        for (int i = 0; i < firstVector.size(); i++) {
            int firstValue = firstVector.get(i);
            int secondValue = secondVector.get(i);

            numerator += firstValue * secondValue;
            denominatorFirst += Math.pow(firstValue, 2);
            denominatorSecond += Math.pow(secondValue, 2);
        }

        double denominator = Math.sqrt(denominatorFirst) * Math.sqrt(denominatorSecond);
        return denominator == 0 ? 0 : numerator / denominator;
    }
}
