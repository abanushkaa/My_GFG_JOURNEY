class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n=arr.length;
        int water=0;
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[i]>arr[s.peek()]){
                int bottom =s.pop();
                if(s.isEmpty() )break;
                int left=s.peek();
                if(s.isEmpty()) break;
                int distance = i-left-1;
                int  boundHeight = Math.min(arr[i], arr[left]) - arr[bottom];

                water+=distance * boundHeight;
            }
            s.push(i);
        }
        return water;
    }
}
