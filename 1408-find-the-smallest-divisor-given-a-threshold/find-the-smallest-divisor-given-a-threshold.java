class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        int current = Integer.MAX_VALUE;

        while(left <= right ){
            int mid = left + (right - left) / 2;
            boolean newCurrent = true;
            int sum  = 0;


            for(int i = 0; i < nums.length; i++){
                sum  += (int) Math.ceil((double) nums[i] / mid);
                if(sum > threshold){
                    newCurrent = false;
                    break;
                }
            }

            if(sum > threshold){
                left = mid + 1;
            }else{
                right = mid - 1;
            }


            if(newCurrent){
                if(mid < current){
                    current = mid;
                }
            }

        }

        return current;
    }
}