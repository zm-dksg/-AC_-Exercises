package org.academiadecodigo.shellmurais;

public class Main {

    public static final String AUTO_PATH = "resources/auto-da-barca-do-inferno.txt";
    public static final String JAVA_PATH = "resources/stream-java-doc.txt";
    public static final int nChar = 10;
    public static final int wordMax = 10;

    public static void main(String[] args) {

        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        // file analyzer with auto da barca do inferno file
        System.out.println("[ " + AUTO_PATH.split("/")[1] + " ]");
        //fileAnalyzer.readWords(AUTO_PATH);
        System.out.println("> Number of words: " + fileAnalyzer.countWords(AUTO_PATH));
        System.out.println("> Number of wines: " + fileAnalyzer.countLines(AUTO_PATH));
        System.out.println("> First word with " + nChar + "+ chars: " +
                fileAnalyzer.findFirst(AUTO_PATH, nChar));
        System.out.println("> The " + wordMax + " biggest words are:");
        fileAnalyzer.biggestWords(AUTO_PATH,wordMax).forEach(System.out::println);

        // file analyzer with java doc file
        System.out.println("\n[ " + JAVA_PATH.split("/")[1] + " ]");
        //fileAnalyzer.readWords(JAVA_PATH);
        System.out.println("> Number of words: " + fileAnalyzer.countWords(JAVA_PATH));
        System.out.println("> Number of wines: " + fileAnalyzer.countLines(JAVA_PATH));
        System.out.println("> First word with " + nChar + "+ chars: " +
                fileAnalyzer.findFirst(JAVA_PATH, nChar));
        System.out.println("> The " + wordMax + " biggest words are:");
        fileAnalyzer.biggestWords(JAVA_PATH,wordMax).forEach(System.out::println);

        System.out.println("\n> Words that are common on both files:");
        fileAnalyzer.commonWords(AUTO_PATH,JAVA_PATH).forEach(System.out::println);
    }

}
