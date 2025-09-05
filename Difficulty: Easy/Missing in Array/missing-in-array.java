

class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length + 1;
        int xor1=0;
        for(int i=1;i<=n;i++){
            xor1=xor1^i;
        }
        int xor2=0;
        for(int i=0;i<arr.length;i++){
            xor2=xor2^arr[i];
        }
        return xor1^xor2;
    }
}