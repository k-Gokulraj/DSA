class Solution {
    public int findKthPositive(int[] arr, int k) {

        int num = 1;
        int count = k;
        int i = 0;

        while (i < arr.length) {

            if (arr[i] == num) {
                i++;
            } else {
                count--;

                if (count == 0) {
                    return num;
                }
            }

            num++;
        }

        // Still need some missing numbers
        return arr[arr.length - 1] + count;
    }
}