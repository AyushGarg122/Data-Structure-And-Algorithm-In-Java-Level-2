import java.util.*;
import java.io.*;
public class Main {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if(amtsf==tamt){
            System.out.println(asf + ".");
            return;
        }
        
        for(int idx=i; idx<coins.length; idx++){
            if(amtsf + coins[idx]<=tamt){
                coinChange(idx,coins,amtsf + coins[idx],tamt,asf + coins[idx] + "-");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}
