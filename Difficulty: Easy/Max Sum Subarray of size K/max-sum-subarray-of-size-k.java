class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n=arr.length;
        // Code here
        int sum=0;
        // int low=0;
        // int high=k-1;
        // int res = Integer.MIN_VALUE;
        for(int i=0;i<k ;i++){
            sum=sum+arr[i];
        }
        int res=sum;
        for(int i=k;i<n;i++){
            sum=sum-arr[i-k]+arr[i];
            res=Math.max(res,sum);
        }
        return res;
    }
}