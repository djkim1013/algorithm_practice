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
        StringTokenizer st=null;
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            if(command.equals("push")){
                int x=Integer.parseInt(st.nextToken());
                stack.push(x);
            }else if(command.equals("pop")){
                if(stack.isEmpty())
                    //System.out.println("-1");
                    answer.append("-1\n");
                else{
                    //System.out.println(stack.peek());
                    answer.append(stack.peek()).append("\n");
                    stack.pop();
                }
            }else if(command.equals("size")){
                //System.out.println(stack.size());
                answer.append(stack.size()).append("\n");
            }else if(command.equals("empty")){
                //System.out.println(stack.isEmpty()?1:0);
                answer.append(stack.isEmpty()?"1\n":"0\n");
            }else if(command.equals("top")){
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