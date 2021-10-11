import java.util.*;
import java.io.*;
public class Main {
    
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        
        return sb.toString();
    }

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if(cs>ts){
            System.out.println(asf + (oddc==null? "" : oddc) + reverse(asf));
            return;
        }
        
        for(Character ch: fmap.keySet()){
            if(fmap.get(ch)>0){
                int freq = fmap.get(ch);
                fmap.put(ch,freq-1);
                generatepw(cs+1,ts,fmap,oddc,asf + ch);
                fmap.put(ch,freq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        int odds = 0;
        Character oddc = null;
        int len = 0;
        
        for(Character key: fmap.keySet()){
            int freq = fmap.get(key);
            
            if(freq % 2==1){
                oddc = key;
                odds++;
            }
            
            fmap.put(key,freq/2);
            len = len + (freq / 2);
        }
        
        if(odds>1){
            System.out.println(-1);
            return;
        }
        
        generatepw(1,len,fmap,oddc,"");
    }
}
