// User function Template for Java



// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;int maxLen=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                int prevIndex=map.get(sum-k);
                int length =i-prevIndex;
                    maxLen = Math.max(maxLen, length);
                
            }if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}