package readability;

public class ReadabilityScoreSMOGAlgorithm implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Simple Measure of Gobbledygook";
    }

    @Override
    public double countScore(Text text) {
        return 1.043
                * Math.sqrt(text.getPolySyllableNumber() * (30 / (float) text.getSentenceNumber()))
                + 3.1291;
    }
}
