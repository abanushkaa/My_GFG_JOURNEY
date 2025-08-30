class Solution {

    void printSquare(int n) {
        for(int i = 1; i <= n; i++){
            if(i == 1 || i == n){
                System.out.print("*".repeat(n));
            }else{
                System.out.print("*");
                System.out.print(" ".repeat(n-2));
                System.out.print("*");
            }
            System.out.println();
        }
    }
}