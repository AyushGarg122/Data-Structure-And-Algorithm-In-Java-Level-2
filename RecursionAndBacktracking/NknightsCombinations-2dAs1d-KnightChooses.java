import java.util.*;
import java.io.*;
public class Main {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        int n = chess.length;
        
        int [][]dir = {{-2,-1}, {-1,-2}, {-2,1}, {-1,2}};
        
        for(int d=0; d<dir.length; d++){
            for(int rad=1; rad<n; rad++){
                int r = i + (rad * dir[d][0]);
                int c = j + (rad * dir[d][1]);
                
                if(r>=0 && c>=0 && r<n && c<n){
                    if(chess[r][c]){
                        return false;
                    }
                }else{
                    break;
                }
            }
        }
        
        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}
