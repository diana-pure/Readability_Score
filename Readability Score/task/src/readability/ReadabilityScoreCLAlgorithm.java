package readability;

public class ReadabilityScoreCLAlgorithm  implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Flesch–Kincaid readability tests";
    }

    @Override
    public double countScore(Text text) {
        return 0;
    }
}
