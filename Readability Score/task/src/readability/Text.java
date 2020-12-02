package readability;

import java.util.Arrays;

public class Text {
    private static final String SENTENCE_SPLIT_REGEXP = "[.!?](\\s)*";
    private static final String WORD_SPLIT_REGEXP = "(\\b|\\W)(\\s)+(\\b|\\W)*";
    private static final String CHARACTER_SPLIT_REGEXP = "\\s";
    private final String text;

    private final int sentenceNumber;

    private final int wordNumber;
    private final int syllableNumber;
    private final int polySyllableNumber;
    private final int characterNumber;

    public Text(String text) {
        this.text = text;
        sentenceNumber = countSentences();
        wordNumber = countWords();
        syllableNumber = countSyllables();
        polySyllableNumber = countPolySyllables();
        characterNumber = countCharacters();
    }

    public void printAttributes() {
        System.out.println("Words: " + wordNumber);
        System.out.println("Sentences: " + sentenceNumber);
        System.out.println("Characters: " + characterNumber);
        System.out.println("Syllables: " + syllableNumber);
        System.out.println("Polysyllables: " + polySyllableNumber);
    }

    public int getSentenceNumber() {
        return sentenceNumber;
    }

    public int getWordNumber() {
        return wordNumber;
    }

    public int getSyllableNumber() {
        return syllableNumber;
    }

    public int getPolySyllableNumber() {
        return polySyllableNumber;
    }

    public int getCharacterNumber() {
        return characterNumber;
    }

    private int countSentences() {
        return text.split(SENTENCE_SPLIT_REGEXP).length;
    }

    private int countWords() {
        return text.split(WORD_SPLIT_REGEXP).length;
    }

    private int countSyllables() {
        return Arrays.stream(text.split(WORD_SPLIT_REGEXP)).map(Text::countSyllables).reduce(0, (Integer::sum));
    }

    private int countPolySyllables() {
        return (int) Arrays.stream(text.split(WORD_SPLIT_REGEXP)).map(Text::countSyllables).filter(e -> e > 2).count();
    }

    private int countCharacters() {
        return Arrays.stream(text.split(CHARACTER_SPLIT_REGEXP)).map(String::length).reduce(0, Integer::sum);
    }

    private static int countSyllables(String word) {
        String wordLower = word.toLowerCase();
        boolean prevIsVowel = false;
        int syllables = 0;
        for (int i = 0; i < wordLower.length(); i++) {
            if (shouldBeIgnored(wordLower.charAt(i), i, wordLower.length())) {
                continue;
            }

            if (!isVowel(wordLower.charAt(i))) {
                prevIsVowel = false;
                continue;
            }

            if (!shouldBeIgnored(wordLower.charAt(i), prevIsVowel)) {
                syllables++;
                prevIsVowel = true;
            }
        }
        return syllables > 0 ? syllables : 1;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'y';
    }

    private static boolean shouldBeIgnored(char c, int position, int length) {
        return (c == 'e') && (position == length - 1);
    }

    private static boolean shouldBeIgnored(char c, boolean prevIsVowel) {
        return prevIsVowel;
    }
}
