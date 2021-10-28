//BOJ 10773
//2021.10.11
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<Integer>();
        int input=0;
        while(k-->0){
            input=Integer.parseInt(br.readLine());
            if(input==0){
                stack.pop();
            }else{
                stack.push(input);
            }
            //System.out.println(stack.toString());
        }
        int answer=0;
        k=stack.size();
        while(k-->0){
            answer+=stack.peek();
            stack.pop();
        }
        System.out.println(answer);
    }
}