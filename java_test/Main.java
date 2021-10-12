//BOJ 1874
//2021.10.12
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    static final String push = "+\n", pop = "-\n", impossible = "NO\n";
    static String makeSeq(int[] goal){
        StringBuilder ret = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int cur=1;
        stack.push(cur);
        for(int i = 0; i < goal.length; i++){
            if(stack.isEmpty()) return impossible;
            while(stack.peek() < goal[i]){
                ret.append(push);
                stack.push(cur++);
            }
            if(stack.peek()!=goal[i]) return impossible;
            ret.append(pop);
            stack.pop();

        }
        return ret.toString();
    }
    public static void main( String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] goal = new int[n];
        for(int i = 0; i < n; i++){
            goal[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(makeSeq(goal));
    }
}