// User function Template for Java


//User function Template for Java
class Solution{
    static ArrayList<Integer> getTable(int N){
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=1; i <= 10 ; i++){
           a.add(i * N);
        }
        return a;
    }
}