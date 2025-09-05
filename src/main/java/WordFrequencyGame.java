import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String ANY_SPACE_SEPARATOR = "\\s+";

    public String getResult(String inputStr){
        String[] words = inputStr.split(ANY_SPACE_SEPARATOR);
        if (words.length == 1) {
            return inputStr + " 1";
        } else {
            try {
                List<Input> wordFrequencies = countFrequencies(words);
                return composeOutput(wordFrequencies);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private String composeOutput(List<Input> wordFrequencies) {
        //split the input string with 1 to n pieces of spaces
        StringJoiner joiner = new StringJoiner("\n");
        wordFrequencies.stream().sorted((w1, w2) -> w2.totalCount() - w1.totalCount()).map(word -> word.word() + " " + word.totalCount()).forEach(joiner::add);
        return joiner.toString();
    }

    private List<Input> countFrequencies(String[] words) {
        Map<String, List<String>> groupWords = new ArrayList<>(List.of(words)).stream().collect(Collectors.groupingBy(word -> word));
        return groupWords.keySet().stream().map(key -> new Input(key, groupWords.get(key).size())).collect(Collectors.toList());
    }

}
