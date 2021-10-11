import java.util.*;
public class Main {

    public static void print(int n, int k){
        if(n>k){
            return;
        }

        System.out.println(n);
        for(int i=0; i<=9; i++){
            print(n * 10 + i,k);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i=1; i<=9; i++){
            print(i,n);
        }
    }
}
