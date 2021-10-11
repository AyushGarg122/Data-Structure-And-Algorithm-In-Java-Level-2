import java.util.*;
import java.io.*;
public class Main {

    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if(minRemoval==0){
            int isValid = getMin(str);
            if(isValid==0 && !ans.contains(str)){
                ans.add(str);
                System.out.println(str);
            }

            return;
        }

        for(int i=0; i<str.length(); i++){
            String  nstr = str.substring(0,i) + str.substring(i+1);
            solution(nstr,minRemoval-1,ans);
        }
    }

    public static int getMin(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else{
                if(st.size()==0 || st.peek()==')'){
                    st.push(ch);
                }else{
                    st.pop();
                }
            }
        }

        return st.size();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str),new HashSet<>());
    }
}
