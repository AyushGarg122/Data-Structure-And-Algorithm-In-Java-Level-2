import java.util.*;
import java.io.*;
public class Main {

    public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
        if(pattern.length()==0){
            if(str.length()==0){
                HashSet<Character> hm = new HashSet<>();
                for(int i=0; i<op.length(); i++){
                    char ch = op.charAt(i);
                    if(!hm.contains(ch)){
                        hm.add(ch);
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                    }
                }
                System.out.println(".");
            }

            return;
        }

        char ch = pattern.charAt(0);

        if(map.containsKey(ch)){
            String mapped = map.get(ch);
            int len = mapped.length();
            if(str.length()>=len && str.substring(0,len).equals(mapped)){
                solution(str.substring(len),pattern.substring(1),map,op);
            }
        }else{
            for(int i=0; i<str.length(); i++){
                String nstr = str.substring(0,i+1);
                map.put(ch,nstr);
                solution(str.substring(i+1),pattern.substring(1),map,op);
                map.remove(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character,String> map = new HashMap<>();
        solution(str,pattern,map,pattern);
    }
}
