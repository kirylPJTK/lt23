package CodeSignal;

import java.util.HashMap;

public class SentimentAnalysis {
    public String[] analyzeSentiments(String[] reviews, String[] positiveWords, String[] negativeWords, String[] intensifiers) {
        String[] results = new String[reviews.length];

        HashMap<String, Integer> positiveWordMap = new HashMap<>();
        for (String word : positiveWords) {
            positiveWordMap.put(word, 1);
        }

        HashMap<String, Integer> negativeWordMap = new HashMap<>();
        for (String word : negativeWords) {
            negativeWordMap.put(word, 1);
        }

        for (int i = 0; i < reviews.length; i++) {
            String[] words = reviews[i].split(" ");
            int positiveCount = 0;
            int negativeCount = 0;

            for (int j = 0; j < words.length; j++) {
                String word = words[j];

                // Check if the word is an intensifier
                if (j < words.length - 1 && isIntensifier(word, intensifiers)) {
                    String nextWord = words[j + 1];
                    if (positiveWordMap.containsKey(nextWord)) {
                        positiveCount++;
                    } else if (negativeWordMap.containsKey(nextWord)) {
                        negativeCount++;
                    }
                    // Skip the next word since it has already been considered
                    j++;
                } else if (positiveWordMap.containsKey(word)) {
                    positiveCount++;
                } else if (negativeWordMap.containsKey(word)) {
                    negativeCount++;
                }
            }

            if (positiveCount > negativeCount) {
                results[i] = "positive";
            } else if (negativeCount > positiveCount) {
                results[i] = "negative";
            } else {
                results[i] = "neutral";
            }
        }

        return results;
    }

    private boolean isIntensifier(String word, String[] intensifiers) {
        for (String intensifier : intensifiers) {
            if (intensifier.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
