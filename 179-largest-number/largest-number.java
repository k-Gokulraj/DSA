import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // Convert int[] to String[]
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {

                String AandB = a + b;
                String BandA = b + a;

                return BandA.compareTo(AandB);
            }
        });

        // Handle [0, 0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}