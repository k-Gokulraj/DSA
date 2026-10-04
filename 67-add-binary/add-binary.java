class Solution {
    public String addBinary(String a, String b) {

        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {

            int c = 0;
            int d = 0;

            if (i >= 0) {
                c = a.charAt(i) - '0';
            }

            if (j >= 0) {
                d = b.charAt(j) - '0';
            }

            int add = c + d + carry;

            if (add == 0) {
                sb.append(0);
                carry = 0;
            }
            else if (add == 1) {
                sb.append(1);
                carry = 0;
            }
            else if (add == 2) {
                sb.append(0);
                carry = 1;
            }
            else { 
                sb.append(1);
                carry = 1;
            }

            i--;
            j--;
        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}