class Solution {

    // Create a palindrome using the first half
    private long makePalindrome(long prefix, int len) {

        String left = String.valueOf(prefix);

        String right;

        if (len % 2 == 0) {
            // Even length
            right = new StringBuilder(left)
                    .reverse()
                    .toString();
        } else {
            // Odd length
            // Don't copy the middle digit twice
            right = new StringBuilder(
                    left.substring(0, left.length() - 1)
            ).reverse().toString();
        }

        return Long.parseLong(left + right);
    }


    public String nearestPalindromic(String n) {

        int len = n.length();
        long num = Long.parseLong(n);

        // Single digit
        if (len == 1) {
            return String.valueOf(num - 1);
        }

        // Take first half
        int halfLength = (len + 1) / 2;

        long prefix = Long.parseLong(
                n.substring(0, halfLength)
        );

        // Three possible palindromes
        long lower = makePalindrome(prefix - 1, len);
        long current = makePalindrome(prefix, len);
        long higher = makePalindrome(prefix + 1, len);

        // Boundary cases
        long all9 = (long) Math.pow(10, len - 1) - 1;
        long oneZeroOne = (long) Math.pow(10, len) + 1;

        long answer = Long.MAX_VALUE;

        answer = getBetter(answer, lower, num);
        answer = getBetter(answer, current, num);
        answer = getBetter(answer, higher, num);
        answer = getBetter(answer, all9, num);
        answer = getBetter(answer, oneZeroOne, num);

        return String.valueOf(answer);
    }


    // Choose the closer palindrome
    private long getBetter(long answer, long candidate, long num) {

        // We cannot return the number itself
        if (candidate == num) {
            return answer;
        }

        // First candidate
        if (answer == Long.MAX_VALUE) {
            return candidate;
        }

        long candidateDiff = Math.abs(candidate - num);
        long answerDiff = Math.abs(answer - num);

        // Candidate is closer
        if (candidateDiff < answerDiff) {
            return candidate;
        }

        // Same distance -> choose smaller
        if (candidateDiff == answerDiff && candidate < answer) {
            return candidate;
        }

        return answer;
    }
}