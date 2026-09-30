import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();

        for (int digit : digits) {
            sb.append(digit);
        }

        BigInteger num = new BigInteger(sb.toString());

        num = num.add(BigInteger.ONE);

        String result = num.toString();

        int[] ans = new int[result.length()];

        for (int i = 0; i < result.length(); i++) {
            ans[i] = result.charAt(i) - '0';
        }

        return ans;
    }
}