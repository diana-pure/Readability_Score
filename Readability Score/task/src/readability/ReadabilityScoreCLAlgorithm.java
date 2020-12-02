package readability;

public class ReadabilityScoreCLAlgorithm  implements ReadabilityScoreAlgorithm {
    @Override
    public String getAlgorithmName() {
        return "Coleman–Liau index";
    }

    @Override
    public double countScore(Text text) {
        return 0.0588 * text.countCharacterLParam() - 0.296 * text.countSentenceSParam() - 15.8;
    }
}
