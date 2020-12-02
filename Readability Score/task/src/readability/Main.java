package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        int wordsNumber = 0;
        int sentenceNumber = 0;
        int charactersNumber = 0;
        long score = 0;

        try {
            String text = new String(Files.readAllBytes(Paths.get(args[0])));
            String[] forCharactersCount = text.split("\\s");
            for(String item : forCharactersCount) {
                charactersNumber += item.length();
            }

            String[] sentences = text.split("[\\.!\\?]");
            sentenceNumber = sentences.length;
            for(String sentence : sentences) {
                String[] words = sentence.trim().split("[\\s]");
                wordsNumber += words.length;
            }
            double sc = 0.0;
            if (wordsNumber != 0) {
                sc = 4.71 * (charactersNumber / (float) wordsNumber) +
                        0.5 * (wordsNumber / (float) sentenceNumber) - 21.43;

            }

            System.out.println("Words: " + wordsNumber);
            System.out.println("Sentences: " + sentenceNumber);
            System.out.println("Characters: " + charactersNumber);
            System.out.printf("The score is: %.2f\n", sc);
            System.out.printf("This text should be understood by %s year olds.", getAge(sc));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getAge(double sc) {
        int score = (int)(Math.ceil(sc));
        switch (score) {
            case 1 : return "6";
            case 2 : return "6-7";
            case 3 : return "7-9";
            case 4 : return "9-10";
            case 5 : return "10-11";
            case 6 : return "11-12";
            case 7 : return "12-13";
            case 8 : return "13-14";
            case 9 : return "14-15";
            case 10 : return "15-16";
            case 11 : return "16-17";
            case 12 : return "17-18";
            case 13 : return "18-24";
            case 14 : return "24+";
            default: return "";
        }
    }
}
