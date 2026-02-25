class Solution {
    public int maxArea(int[] arr) {
        if (arr.length < 2) return 0;

        int left = 0;
        int right = arr.length-1;
        int maxArea = 0;
        while(left!=right){
            int area = Math.min(arr[left], arr[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

             if(arr[left]<arr[right]){
                left++;
             }else{
                right--;
             }
        }
        return maxArea;
    }
}