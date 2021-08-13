package org.academiadecodigo.shellmurais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalyzer {

    public void readWords(String path) {

        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            stream.flatMap(str -> Stream.of(str.split(" "))).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countWords(String path) {

        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            return stream.flatMap(str -> Stream.of(str.split(" "))).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public long countLines(String path) {

        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            return stream.count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String findFirst(String path, int nChar) {

        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            return stream.flatMap(str -> Stream.of(str.split(" ")))
                    .filter(str -> str.length() >= nChar)
                    .findFirst()
                    .get();
        } catch (IOException | NoSuchElementException e) {
            return "none";
        }

    }

    public List<String> biggestWords(String path, int wordMax) {

        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            return stream.flatMap(str -> Stream.of(str.split(" ")))
                    .sorted((str1,str2) -> str2.length() - str1.length())
                    .limit(wordMax)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<String> commonWords(String path1, String path2) {

        try {
            Stream<String> stream1 = Files.lines(Paths.get(path1));
            List<String> file1List = stream1.flatMap(str -> Stream.of(str.split(" ")))
                    .sorted((str1,str2) -> str2.length() - str1.length())
                    .collect(Collectors.toList());

            Stream<String> stream2 = Files.lines(Paths.get(path2));
            return stream2.flatMap(str -> Stream.of(str.split(" ")))
                    .filter(file1List::contains)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
