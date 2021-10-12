//BOJ 9012
//2021.10.12
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    static String checkVPS(String input){
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(c==')'){
                if(stack.isEmpty()){
                    return "NO\n";
                }else{
                    stack.pop();
                }
            }else if(c=='('){
                stack.push(1);
            }
        }
        if(stack.isEmpty()) return "YES\n";
        return "NO\n";
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            answer.append(checkVPS(br.readLine()));
        }
        System.out.print(answer);
    }
}