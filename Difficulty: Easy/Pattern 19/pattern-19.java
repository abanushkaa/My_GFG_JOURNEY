

class Solution {

    void printTriangle(int n) {
        // code here
        int ch=0;
        for(int i=0;i<n;i++){
            //STARS
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=0;j<ch;j++){
                System.out.print(" ");
            }
             //STARS
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }
            ch+=2;
            System.out.println();
        }
        ch=(n-1)*2;
        for(int i=0;i<n;i++){
            //STARS
            for(int j=1;j<=i+1;j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=0;j<ch;j++){
                System.out.print(" ");
            }
             //STARS
            for(int j=1;j<=i+1;j++){
                System.out.print("*");
            }
            ch -= 2;
            System.out.println();
    }
}
}