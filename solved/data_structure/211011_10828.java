//BOJ 10828
//2021.10.11
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    static Stack<Integer> stack=new Stack<Integer>();
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String input;
        StringBuilder answer=new StringBuilder();
        while(n-->0){
            input=br.readLine();
            char command=input.charAt(0);
            if(command=='p'){
                if(input.charAt(1)=='u'){
                    int x=Integer.parseInt(input.substring(input.indexOf(" ")+1));
                    stack.push(x);
                }else{
                    if(stack.isEmpty())
                        //System.out.println("-1");
                        answer.append("-1\n");
                    else{
                        //System.out.println(stack.peek());
                        answer.append(stack.peek()).append("\n");
                        stack.pop();
                    }
                }
            }else if(command=='s'){
                //System.out.println(stack.size());
                answer.append(stack.size()).append("\n");
            }else if(command=='e'){
                //System.out.println(stack.isEmpty()?1:0);
                answer.append(stack.isEmpty()?"1\n":"0\n");
            }else{
                if(stack.isEmpty()) 
                    //System.out.println("-1");
                    answer.append("-1\n");
                else{
                    //System.out.println(stack.peek());
                    answer.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(answer);
    }
}