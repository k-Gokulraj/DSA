class Solution {

    public void findSecretWord(String[] words, Master master) {

        List<String> candidates = new ArrayList<>();

        for (String word : words) {
            candidates.add(word);
        }

        while (!candidates.isEmpty()) {

            // Choose the best word to guess
            String guess = getBestGuess(candidates);

            // Ask Master
            int matches = master.guess(guess);

            // Found the secret
            if (matches == 6) {
                return;
            }

            // Filter candidates
            List<String> next = new ArrayList<>();

            for (String word : candidates) {

                if (matchCount(guess, word) == matches) {
                    next.add(word);
                }
            }

            candidates = next;
        }
    }

    // Finds how many positions are exactly the same
    private int matchCount(String a, String b) {

        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    // Choose the word that minimizes the largest possible group
    private String getBestGuess(List<String> candidates) {

        String bestWord = candidates.get(0);
        int bestScore = Integer.MAX_VALUE;

        for (String guess : candidates) {

            int[] groups = new int[7];

            // See how this guess divides the candidates
            for (String word : candidates) {

                int matches = matchCount(guess, word);

                groups[matches]++;
            }

            // Worst-case number of candidates remaining
            int worstGroup = 0;

            for (int count : groups) {
                worstGroup = Math.max(worstGroup, count);
            }

            // We want the smallest worst-case group
            if (worstGroup < bestScore) {
                bestScore = worstGroup;
                bestWord = guess;
            }
        }

        return bestWord;
    }
}