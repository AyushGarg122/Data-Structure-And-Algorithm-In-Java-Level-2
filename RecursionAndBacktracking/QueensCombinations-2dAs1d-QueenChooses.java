import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
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
        
        for(int i=lcno+1; i<n*n; i++){
            int r = i / n;
            int c = i % n;
            chess[r][c] = true;
            queensCombinations(qpsf+1,tq,chess,i);
            chess[r][c] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
