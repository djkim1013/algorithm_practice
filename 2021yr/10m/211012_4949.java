//BOJ 4949
//2021.10.12
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    static final Map<Character,Character> prPair=new HashMap<Character,Character>(){{
        put(')','(');
        put('}','{');
        put(']','[');
    }};
    static String checkVPS(String input){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(prPair.containsKey(c)){
                if(stack.isEmpty()||stack.peek()!=prPair.get(c)){
                    return "no\n";
                }else{
                    stack.pop();
                }
            }else if(prPair.containsValue(c)){
                stack.push(c);
            }
        }
        if(stack.isEmpty()) return "yes\n";
        return "no\n";
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        while(true){
            StringBuilder input=new StringBuilder(br.readLine());
            if(input.toString().equals("."))break;
            while(input.charAt(input.length()-1)!='.'){
                input.append(br.readLine());
            }
            answer.append(checkVPS(input.toString()));
        }
        System.out.print(answer);
    }
}