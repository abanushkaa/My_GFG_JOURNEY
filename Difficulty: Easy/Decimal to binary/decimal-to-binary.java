class Solution {
    static String decToBinary(int n) {
        // code here
        if(n==0) return"0";
        
            String binary="";
            while(n>0){
            int remainder= n%2;
            binary = remainder+binary;
            n=n/2;
            
        }
        return binary;
    }
}