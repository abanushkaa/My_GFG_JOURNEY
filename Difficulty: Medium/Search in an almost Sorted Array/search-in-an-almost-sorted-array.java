// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        // code here
        int n=arr.length;int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(mid >start && arr[mid-1]==target)
                return mid-1;
            if(mid<end && arr[mid+1]==target)
                return mid+1;
            if(arr[mid]>target)
                end=mid-2;
            else
                start=mid+2;
        }
        return -1;
    }
}