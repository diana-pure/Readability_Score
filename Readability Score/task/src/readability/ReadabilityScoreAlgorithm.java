package readability;

public interface ReadabilityScoreAlgorithm {
    String getAlgorithmName();
    double countScore(Text text);
}
