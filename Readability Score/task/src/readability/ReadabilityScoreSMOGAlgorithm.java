package readability;

public class ReadabilityScoreSMOGAlgorithm implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Coleman–Liau index";
    }

    @Override
    public double countScore(Text text) {
        return 0;
    }
}
