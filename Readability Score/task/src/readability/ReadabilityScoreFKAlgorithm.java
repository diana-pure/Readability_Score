package readability;

public class ReadabilityScoreFKAlgorithm implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Simple Measure of Gobbledygook";
    }

    @Override
    public double countScore(Text text) {
        return 0;
    }
}
