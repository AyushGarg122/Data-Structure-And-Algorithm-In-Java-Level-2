import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];

        boolean[]col = new boolean[n];
        boolean[]d1 = new boolean[n + n - 1];
        boolean[]d2 = new boolean[n + n - 1];

        NQueens(board,0,col,d1,d2,"");
    }

    public static void NQueens(boolean[][]chess, int row, boolean[] col, boolean[] d1, boolean[] d2, String ans){
        int n = chess.length;

        if(row==n){
            System.out.println(ans + ".");
            return;
        }

        for(int c=0; c<n; c++){
            if(!col[c] && !d1[row+c] && !d2[row - c + n - 1]){
                col[c] = d1[row + c] = d2[row - c + n - 1] = true;
                NQueens(chess,row+1,col,d1,d2,ans + row + "-" + c + ", ");
                col[c] = d1[row + c] = d2[row - c + n - 1] = false;
            }
        }
    }
}
