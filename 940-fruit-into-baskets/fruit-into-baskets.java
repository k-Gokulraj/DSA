class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;

        int bucket1 = -1;
        int bucket2 = -1;

        int count1 = 0;
        int count2 = 0;

        int max = 0;

        while (right < fruits.length) {

            int current = fruits[right];

            // Fruit already exists in bucket1
            if (current == bucket1) {
                count1++;
                right++;
            }

            // Fruit already exists in bucket2
            else if (current == bucket2) {
                count2++;
                right++;
            }

            // Bucket1 is empty
            else if (bucket1 == -1) {
                bucket1 = current;
                count1 = 1;
                right++;
            }

            // Bucket2 is empty
            else if (bucket2 == -1) {
                bucket2 = current;
                count2 = 1;
                right++;
            }

            // Third fruit type
            else {

                while (count1 > 0 && count2 > 0) {

                    if (fruits[left] == bucket1) {
                        count1--;
                    } else {
                        count2--;
                    }

                    left++;
                }

                // One basket is now empty
                if (count1 == 0) {
                    bucket1 = current;
                    count1 = 1;
                } else {
                    bucket2 = current;
                    count2 = 1;
                }

                right++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}