import java.util.*;
import java.io.*;
public class Main {

    static int max = 0;

    public static int getMaxGold(int[][] arr, int r, int c, int [][]dir){
        int n = arr.length, m = arr[0].length;

        int val = arr[r][c];
        arr[r][c] = 0;

        int gold = 0;

        for(int i=0; i<dir.length; i++){
            int sr = r + dir[i][0];
            int sc = c + dir[i][1];

            if(sr>=0 && sc>=0 && sr<n && sc<m && arr[sr][sc]!=0){
                gold+= getMaxGold(arr,sr,sc,dir);
            }
        }

        return gold + val;
    }

    public static void getMaxGold(int[][] arr){

        int [][]dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        int n = arr.length, m = arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]>0){
                    int gold = getMaxGold(arr,i,j,dir);
                    max = Math.max(max,gold);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j  < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }
}
