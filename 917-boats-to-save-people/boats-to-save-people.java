class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length-1;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                count++;
                left++;
                right--;
            }else if(people[right] <= limit){
                right--;
                count++;
            }else if(people[left] <= limit){
                left++;
                count++;
            }
        }

        return count;
    }
}