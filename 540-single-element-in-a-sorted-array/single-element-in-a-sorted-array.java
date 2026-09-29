class Solution {

    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 1. Is mid itself the single element?
            if ((mid == left || nums[mid] != nums[mid - 1]) &&
                (mid == right || nums[mid] != nums[mid + 1])) {

                return nums[mid];
            }

            // 2. Pair is (mid - 1, mid)
            if (mid > left && nums[mid] == nums[mid - 1]) {

                int leftLength = mid - left - 1;
                int rightLength = right - mid;

                // Left side has odd number of elements
                if (leftLength % 2 == 1) {

                    right = mid - 2;
                }

                // Right side has odd number of elements
                else {

                    left = mid + 1;
                }
            }

            // 3. Pair is (mid, mid + 1)
            else {

                int leftLength = mid - left;
                int rightLength = right - mid - 1;

                // Left side has odd number of elements
                if (leftLength % 2 == 1) {

                    right = mid - 1;
                }

                // Right side has odd number of elements
                else {

                    left = mid + 2;
                }
            }
        }

        return -1;
    }
}