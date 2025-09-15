class Solution {
    int majorityElement(int arr[]) {
        // code here
        int candidate=0;
        int count=0;
        for(int num:arr){
            if (count==0){
                candidate=num;
            }
            if (num == candidate){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // Step 3: Return candidate only if it is majority
        if (count > arr.length / 2) {
            return candidate;
        }
        return -1;
    }
}