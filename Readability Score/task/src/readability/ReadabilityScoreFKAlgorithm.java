package readability;

public class ReadabilityScoreFKAlgorithm implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Flesch–Kincaid readability tests";
    }

    @Override
    public double countScore(Text text) {
        return 0.39 * (text.getWordNumber() / (float) text.getSentenceNumber())
                + 11.8 * (text.getSyllableNumber() / (float) text.getWordNumber())
                - 15.59;
    }
}
