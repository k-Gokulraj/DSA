import java.util.*;

class Solution {

    public void findSecretWord(String[] words, Master master) {

        int n = words.length;

        // match[i][j] = number of positions where
        // words[i] and words[j] are equal
        int[][] match = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int count = 0;

                for (int k = 0; k < 6; k++) {
                    if (words[i].charAt(k) == words[j].charAt(k)) {
                        count++;
                    }
                }

                match[i][j] = count;
                match[j][i] = count;
            }
        }

        List<Integer> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            candidates.add(i);
        }

        while (!candidates.isEmpty()) {

            int guess = getBestGuess(candidates, match);

            int result = master.guess(words[guess]);

            if (result == 6) {
                return;
            }

            List<Integer> next = new ArrayList<>();

            for (int candidate : candidates) {

                if (match[guess][candidate] == result) {
                    next.add(candidate);
                }
            }

            candidates = next;
        }
    }

    private int getBestGuess(List<Integer> candidates, int[][] match) {

        int bestGuess = candidates.get(0);
        int bestWorstCase = Integer.MAX_VALUE;

        for (int guess : candidates) {

            int[] groups = new int[7];

            for (int candidate : candidates) {
                groups[match[guess][candidate]]++;
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