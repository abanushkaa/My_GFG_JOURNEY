// User function Template for Java

class Solution {
    public boolean checkDuplicates(int arr[]) {
        // Code here
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                return true;
            }
            
        }
        return false;
    }
}