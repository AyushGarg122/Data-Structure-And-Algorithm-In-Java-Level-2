import java.util.*;
public class Main {

    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafeToPlaceNumber(int [][]board, int r, int c, int num){
        for(int i=0; i<9; i++){
            if(board[r][i]==num){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(board[i][c]==num){
                return false;
            }
        }

        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[r+i][c+j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] board, ArrayList<Integer>emptyIndex, int idx) {
        if(idx==emptyIndex.size()){
            display(board);
            return true;
        }
        
        int ele = emptyIndex.get(idx);
        
        int r = ele / 9;
        int c = ele % 9;
        
        for(int num=1; num<=9; num++){
            if(isSafeToPlaceNumber(board,r,c,num)){
                board[r][c] = num;
                if(solveSudoku(board,emptyIndex,idx+1)){
                    return true;
                }
                board[r][c] = 0;
            }
        }
        
        return false;
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        ArrayList<Integer> emptyIndex = new ArrayList<>();

        int n = board.length;

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if(board[i][j]==0){
                    emptyIndex.add(i * 9 + j);
                }
            }
        }
        
        solveSudoku(board,emptyIndex,0);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}
