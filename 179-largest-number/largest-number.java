class Solution {
    public String largestNumber(int[] nums) {
        // Convert to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }

        // Manual bubble sort: put "bigger" concatenation first
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                String AandB = arr[j] + arr[j + 1];
                String BandA = arr[j + 1] + arr[j];

                // If B+A is bigger, swap
                if (BandA.compareTo(AandB) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Edge case: all zeros → "0"
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}