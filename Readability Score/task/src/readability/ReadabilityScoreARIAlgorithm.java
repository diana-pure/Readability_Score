package readability;

public class ReadabilityScoreARIAlgorithm implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Automated Readability Index";
    }

    @Override
    public double countScore(Text text) {
        double sc = 0.0;
        if (text.getWordNumber() != 0) {
            sc = 4.71 * (text.getCharacterNumber() / (float) text.getWordNumber()) +
                    0.5 * (text.getWordNumber() / (float) text.getSentenceNumber()) - 21.43;

        }
        return sc;
    }
}
