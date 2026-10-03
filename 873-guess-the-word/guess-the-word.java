import java.util.*;

class Solution {

 public void findSecretWord(String[] words, Master master) {

    List<String> candidates = new ArrayList<>(Arrays.asList(words));

    while (!candidates.isEmpty()) {

        String guess = getBestGuess(candidates);

        int matches = master.guess(guess);

        if (matches == 6) {
            return;
        }

        List<String> filtered = new ArrayList<>();

        for (String word : candidates) {

            if (match(word, guess) == matches) {
                filtered.add(word);
            }
        }

        candidates = filtered;
    }
}

private int match(String a, String b) {

    int count = 0;

    for (int i = 0; i < 6; i++) {
        if (a.charAt(i) == b.charAt(i)) {
            count++;
        }
    }

    return count;
}

private String getBestGuess(List<String> candidates) {

    String bestGuess = candidates.get(0);
    int bestWorstCase = Integer.MAX_VALUE;

    for (String guess : candidates) {

        int[] groups = new int[7];

        for (String word : candidates) {

            int matches = match(guess, word);

            groups[matches]++;
        }

        int worstCase = 0;

        for (int count : groups) {
            worstCase = Math.max(worstCase, count);
        }

        if (worstCase < bestWorstCase) {
            bestWorstCase = worstCase;
            bestGuess = guess;
        }
    }

    return bestGuess;
}

}