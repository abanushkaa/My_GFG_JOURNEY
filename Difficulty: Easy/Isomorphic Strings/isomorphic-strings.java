class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        if(s1.length() != s2.length()) return false;
        int[] mapS1 = new int[256];
        int[] mapS2 = new int[256];
        for(int i=0;i<s1.length();i++){
            char cs1 = s1.charAt(i);
            char cs2 = s2.charAt(i);
            
            if(mapS1[cs1] != mapS2[cs2]) return false;
            
            mapS1[cs1] = i+1;
            mapS2[cs2] = i+1;
        }
        return true;
    }
}