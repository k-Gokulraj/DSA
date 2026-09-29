class Solution {

    public String nearestPalindromic(String n) {

        int len = n.length();

        // Special cases
        if (n.equals("1")) {
            return "0";
        }

        // Candidates for boundary cases
        long lowerBoundary = (long) Math.pow(10, len - 1) - 1;
        long upperBoundary = (long) Math.pow(10, len) + 1;

        // Take the left half
        int halfLen = (len + 1) / 2;

        long left = Long.parseLong(n.substring(0, halfLen));

        // Three main candidates
        long p1 = makePalindrome(left - 1, len);
        long p2 = makePalindrome(left, len);
        long p3 = makePalindrome(left + 1, len);

        long original = Long.parseLong(n);

        long answer = -1;
        long minDistance = Long.MAX_VALUE;

        long[] candidates = {
            lowerBoundary,
            upperBoundary,
            p1,
            p2,
            p3
        };

        for (long candidate : candidates) {

            // Don't choose the number itself
            if (candidate == original) {
                continue;
            }

            long distance = Math.abs(candidate - original);

            // Smaller distance wins
            // If same distance, smaller number wins
            if (distance < minDistance ||
                (distance == minDistance && candidate < answer)) {

                minDistance = distance;
                answer = candidate;
            }
        }

        return String.valueOf(answer);
    }


    private long makePalindrome(long left, int len) {

        String s = String.valueOf(left);

        StringBuilder sb = new StringBuilder(s);

        // For odd length, don't duplicate middle digit
        int start;

        if (len % 2 == 0) {
            start = s.length() - 1;
        } else {
            start = s.length() - 2;
        }

        for (int i = start; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }
}