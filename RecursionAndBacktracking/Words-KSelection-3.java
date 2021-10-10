import java.util.*;
import java.io.*;
public class Main {

    public static void generateSelection(int cc, String ustr, int ssf, int ts, HashMap<Character, Integer> unique, String asf) {
        if(cc==ustr.length() || ssf==ts){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(cc);


        if(unique.get(ch)>0){
            int val = unique.get(ch);
            unique.put(ch,val-1);
            generateSelection(cc,ustr,ssf+1,ts,unique,asf + ch);
            unique.put(ch,val);
        }

        generateSelection(cc + 1,ustr,ssf,ts,unique,asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        generateSelection(0, ustr, 0, k, unique, "");
    }
}
