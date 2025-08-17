
class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        // code here
        int n=arr.length;
        int m=indices.length;
        int[] result = new int[m];
        for(int k=0;k<m;k++){
            int i=indices[k];
            int count=0;
            for(int j= i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    count++;
                }
            }
            result [k] =count;
        }
        return result;
    }
}
