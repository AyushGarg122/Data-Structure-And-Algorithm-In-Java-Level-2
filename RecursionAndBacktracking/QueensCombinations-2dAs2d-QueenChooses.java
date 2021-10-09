import java.util.*;
import java.io.*;
public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        int n = chess.length;

        if(qpsf==tq){
            for(int r=0; r<chess.length; r++){
                for(int c=0; c<chess.length; c++){
                    if(chess[r][c]){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int r=i; r<n; r++){
            for(int c = r==i? j+1: 0; c<n; c++){
                chess[r][c] = true;
                queensCombinations(qpsf+1,tq,chess,r,c);
                chess[r][c] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, 0, -1);
    }
}
