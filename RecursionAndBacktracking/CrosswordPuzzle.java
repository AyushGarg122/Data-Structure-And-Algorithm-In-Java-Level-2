import java.util.*;
import java.io.*;
public class Main {

    public static boolean isPossibleToPlace_H(char[][]board, int r, int c, String word){
        int l = word.length(), m = board[0].length;

        if(c + l > m){
            return false;
        }

        if(c==0 && c + l<m && board[r][c+l]!='+'){
            return false;
        }

        if(c!=0 && c+l==m && board[r][c-1]!='+'){
            return false;
        }

        if(c!=0 && c+l<m && (board[r][c+l]!='+' || board[r][c-1]!='+')){
            return false;
        }

        for(int i=0; i<word.length(); i++){
            if(board[r][c+i]!='-' && board[r][c+i]!=word.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static int place_H(char[][]board, int r, int c, String word){
        int loc = 0;

        for(int i=0; i<word.length(); i++){
            if(board[r][c + i]=='-'){
                int mask = 1 << i;
                loc = loc ^ mask;
                board[r][c + i] = word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlace_H(char[][]board, int r,int c, String word, int loc){
        for(int i=0; i<word.length(); i++){
            int mask = 1 << i;
            if((mask & loc)!=0){
                board[r][c + i] = '-';
            }
        }
    }

    public static boolean isPossibleToPlace_V(char[][]board, int r, int c, String word){
        int l = word.length(), n = board.length;

        if(r + l > n){
            return false;
        }

        if(r==0 && r + l<n && board[r+l][c]!='+'){
            return false;
        }

        if(r!=0 && r+l==n && board[r-1][c]!='+'){
            return false;
        }

        if(r!=0 && r+l<n && (board[r+l][c]!='+' || board[r-1][c]!='+')){
            return false;
        }

        for(int i=0; i<word.length(); i++){
            if(board[r+i][c]!='-' && board[r+i][c]!=word.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static int place_V(char[][]board, int r, int c, String word){
        int loc = 0;

        for(int i=0; i<word.length(); i++){
            if(board[r + i][c]=='-'){
                int mask = 1 << i;
                loc = loc ^ mask;
                board[r + i][c] = word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlace_V(char[][]board, int r,int c, String word, int loc){
        for(int i=0; i<word.length(); i++){
            int mask = 1 << i;
            if((mask & loc)!=0){
                board[r + i][c] = '-';
            }
        }
    }

    public static void solution(char[][] arr, String[] words, int vidx) {
        if(vidx==words.length){
            print(arr);
            return;
        }

        String word = words[vidx];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]=='-' || arr[i][j] == word.charAt(0)){

                    if(isPossibleToPlace_H(arr,i,j,word)){
                        int loc = place_H(arr,i,j,word);
                        solution(arr,words,vidx+1);
                        unPlace_H(arr,i,j,word,loc);
                    }

                    if(isPossibleToPlace_V(arr,i,j,word)){
                        int loc = place_V(arr,i,j,word);
                        solution(arr,words,vidx+1);
                        unPlace_V(arr,i,j,word,loc);
                    }
                }
            }
        }
    }


    public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0 ; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i  < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}
