// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        // code here
        int n= arr.length;
        // if (n <= 1) return;
        rev(arr,0,n-2);
        rev(arr,0,n-1);
    }
        private void rev(int[] arr, int left, int right){
            while(left< right){
            int temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
            
        }
    }
}