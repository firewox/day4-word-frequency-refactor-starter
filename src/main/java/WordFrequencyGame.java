import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

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
        wordFrequencies.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : wordFrequencies) {
            String s = w.getValue() + " " +w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private List<Input> countFrequencies(String[] words) {
        Map<String, List<String>> groupWords = groupSameWord(words);
        List<Input> frequencies = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groupWords.entrySet()){
            Input input = new Input(entry.getKey(), entry.getValue().size());
            frequencies.add(input);
        }
        return frequencies;
    }

    private static Map<String, List<String>> groupSameWord(String[] words) {
        List<String> inputList = new ArrayList<>(List.of(words));
        //get the map for the next step of sizing the same word
        Map<String, List<String>> groupWords = new HashMap<>();
        for (String input1 : inputList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!groupWords.containsKey(input1)){
                ArrayList arr = new ArrayList<>();
                arr.add(input1);
                groupWords.put(input1, arr);
            }
            else {
                groupWords.get(input1).add(input1);
            }
        }
        return groupWords;
    }
}
