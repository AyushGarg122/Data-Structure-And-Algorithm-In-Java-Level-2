import java.util.*;
import java.io.*;
public class Main {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx==words.length){
            return 0;
        }
        
        int ans1 = solution(words,farr,score,idx+1);

        int Score = 0;
        boolean flag = true;
        String word = words[idx];

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(farr[ch - 'a']<=0){
                flag = false;
            }

            farr[ch - 'a']--;
            Score = Score + score[ch - 'a'];
        }

        int ans2 = 0;
        if(flag){
            ans2 = Score + solution(words,farr,score,idx+1);
        }

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }

        return Math.max(ans1,ans2);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

    }
}
