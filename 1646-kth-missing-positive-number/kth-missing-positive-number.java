class Solution {
    public int findKthPositive(int[] arr, int k) {
       int MissCount = 0;
       int num = 1;
       int i = 0;

       while(MissCount < k){
        
        if(i < arr.length && num == arr[i]){
            i++;
        }else{
            MissCount++;

            if(MissCount == k){
                return num;
            }
        }
        num++;
       }

       return -1;

    }
}