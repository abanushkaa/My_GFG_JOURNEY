class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int start=0;int end= arr.length-1;
        int n=arr.length;
        while(start<=end){
            if(arr[start]<=arr[end]){
                return start;
            }
            int mid = start+ (end-start)/2;
            int next= (mid+1)%n;
            int prev = (mid-1 + n)%n;
            if (arr[mid]<=arr[next] && arr[mid]<=arr[prev]){
                return mid;
            }
            if (arr[start]<=arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return 0;
    }
}