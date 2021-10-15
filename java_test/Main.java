//BOJ 6549
//2021.10.15
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        while((input=br.readLine()).charAt(0)!='0'){
            st=new StringTokenizer(input);
            int n=Integer.parseInt(st.nextToken());
            int[] arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
            long max=0;
            Stack<Integer> stk=new Stack<Integer>();
            for(int i=0;i<n;i++){
                if(stk.isEmpty()||stk.peek()<=arr[i]){
                    stk.add(arr[i]);
                }else{
                    max=Math.max(max,(long)stk.peek()*stk.size());
                    stk.add(arr[i]);
                }
            }
            answer.append(max).append("\n");
        }
        System.out.print(answer);
    }
}