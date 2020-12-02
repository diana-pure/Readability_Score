package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Text text = new Text(new String(Files.readAllBytes(Paths.get(args[0]))));
            text.printAttributes();

            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            ReadabilityScoreAlgorithmType ra = ReadabilityScoreAlgorithmType.fromString((new Scanner(System.in)).next());

            int ageSum = 0;
            int algCount = 0;
            for (ReadabilityScoreAlgorithm a : ra.getAlgorithms()) {
                double score = a.countScore(text);
                algCount++;
                ageSum += getAge(score);
                if(ra.getAlgorithms().size() > 1) {
                    System.out.printf("%s: %.2f (about %d year olds).\n", a.getAlgorithmName(), score, getAge(score));
                } else {
                    System.out.printf("\nThis text should be understood by %s year olds.\n", getAgeRange(score));
                }
            }

            if(ra.getAlgorithms().size() > 1) {
                System.out.printf("\nThis text should be understood in average by %.2f year olds.\n", ageSum / (float) algCount);
            }
        } catch (IOException e) {
            System.err.printf("File %s could not be read.\n", args[0]);
        }
    }


    private static String getAgeRange(double sc) {
        int score = (int) (Math.ceil(sc));
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

    private static int getAge(double sc) {
        int score = (int) (Math.ceil(sc));
        switch (score) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
                return 24;
            case 14:
                return 25;
            default:
                return 0;
        }
    }
}
