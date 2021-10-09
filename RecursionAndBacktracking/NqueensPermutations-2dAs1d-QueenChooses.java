import java.util.*;
import java.io.*;
public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        int [][]dir = {{-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}};

        int n = chess.length;

        for(int i=0; i<dir.length; i++){
            for(int rad=1; rad<n; rad++){
                int sr = row + (rad * dir[i][0]);
                int sc = col + (rad * dir[i][1]);

                if(sr>=0 && sc>=0 && sr<n && sc<n){
                    if(chess[sr][sc]!=0){
                        return false;
                    }
                }else{
                    break;
                }
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        int n = chess.length;

        if(qpsf==tq){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(chess[i][j]!=0){
                        System.out.print("q" + (chess[i][j]) + "\t");
                    }else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }

            System.out.println();
            return;
        }

        for(int i=0; i<n*n; i++){
            int r = i / n;
            int c = i % n;

            if(chess[r][c]==0 && IsQueenSafe(chess,r,c)){
                chess[r][c] = qpsf + 1;
                nqueens(qpsf+1,tq,chess);
                chess[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
