class Solution {

   private long makePalindrome(long prefix, int len) {

    String left = String.valueOf(prefix);

    StringBuilder sb = new StringBuilder(left);

    if (len % 2 == 0) {
        sb.append(new StringBuilder(left)
                .reverse());

    } else {
        String remaining = left.substring(0, left.length() - 1);

        sb.append(new StringBuilder(remaining)
                .reverse());
    }

    return Long.parseLong(sb.toString());
}

    public String nearestPalindromic(String n) {

        int len = n.length();

        if (len == 1) {
            return String.valueOf(Long.parseLong(n) - 1);
        }

        long num = Long.parseLong(n);

        int halfLength = (len + 1) / 2;

        long prefix = Long.parseLong(
                n.substring(0, halfLength)
        );

        long answer = Long.MAX_VALUE;

        answer = better(answer,
                makePalindrome(prefix - 1, len),
                num);

        answer = better(answer,
                makePalindrome(prefix, len),
                num);

        answer = better(answer,
                makePalindrome(prefix + 1, len),
                num);

        long all9 = power10(len - 1) - 1;

        answer = better(answer, all9, num);

        long boundary = power10(len) + 1;

        answer = better(answer, boundary, num);

        return String.valueOf(answer);
    }

    private long better(long current, long candidate, long num) {

        if (candidate == num) {
            return current;
        }

        if (current == Long.MAX_VALUE) {
            return candidate;
        }

        long candidateDiff = Math.abs(candidate - num);
        long currentDiff = Math.abs(current - num);

        if (candidateDiff < currentDiff ||
            (candidateDiff == currentDiff && candidate < current)) {
            return candidate;
        }

        return current;
    }

    private long power10(int n) {

        long result = 1;

        while (n-- > 0) {
            result *= 10;
        }

        return result;
    }
}