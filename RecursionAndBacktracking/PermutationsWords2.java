import java.util.*;
import java.io.*;
public class Main {

    public static void generateWords(int cc, String str, Character[] spots,
                                     HashMap<Character, Integer> lastOccurence) {

        if(cc==str.length()){
            for(Character s: spots){
                System.out.print(s);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);

        for(int i=lo+1; i<spots.length; i++){
            if(spots[i]==null){
                spots[i] = ch;
                lastOccurence.put(ch,i);
                generateWords(cc+1,str,spots,lastOccurence);
                spots[i] = null;
                lastOccurence.put(ch,lo);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(char ch: str.toCharArray()){
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, spots, lastOccurence);
    }
}
