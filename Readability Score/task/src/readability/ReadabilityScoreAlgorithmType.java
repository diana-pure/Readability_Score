package readability;

import java.util.Collections;
import java.util.List;

public enum ReadabilityScoreAlgorithmType {
    ARI(List.of(new ReadabilityScoreARIAlgorithm())),  // Automated Readability Index
    FK(List.of(new ReadabilityScoreARIAlgorithm())),   // Flesch–Kincaid
    SMOG(List.of(new ReadabilityScoreARIAlgorithm())), // Simple Measure of Gobbledygook
    CL(List.of(new ReadabilityScoreARIAlgorithm())),   // Coleman–Liau

    ALL(List.of(                                       // all
            new ReadabilityScoreARIAlgorithm(),
            new ReadabilityScoreFKAlgorithm(),
            new ReadabilityScoreSMOGAlgorithm(),
            new ReadabilityScoreCLAlgorithm()
    )),

    NONE(Collections.emptyList());  // none

    private List<ReadabilityScoreAlgorithm> algorithms;

    ReadabilityScoreAlgorithmType(List<ReadabilityScoreAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public static ReadabilityScoreAlgorithmType fromString(String s) {
        switch (s) {
            case "ARI":
                return ReadabilityScoreAlgorithmType.ARI;
            case "FK":
                return ReadabilityScoreAlgorithmType.FK;
            case "SMOG":
                return ReadabilityScoreAlgorithmType.SMOG;
            case "CL":
                return ReadabilityScoreAlgorithmType.CL;
            case "all":
                return ReadabilityScoreAlgorithmType.ALL;
            default:
                return ReadabilityScoreAlgorithmType.NONE;
        }
    }

    public List<ReadabilityScoreAlgorithm> getAlgorithms() {
        return algorithms;
    }
}
