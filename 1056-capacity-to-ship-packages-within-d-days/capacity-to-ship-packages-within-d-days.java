class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int num : weights) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int sum = 0;
            int daysRequired = 1;

            for (int num : weights) {

                if (sum + num > mid) {
                    sum = num;
                    daysRequired++;
                } 
                else {
                    sum += num;
                }
            }

            if (daysRequired <= days) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}