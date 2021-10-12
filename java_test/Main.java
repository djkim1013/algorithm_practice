//BOJ 1874
//2021.10.12
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Stack<Integer> rNum=new Stack<Integer>();
        StringBuilder answer=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            int cur=arr[i];
            while(!rNum.empty()&&cur>=rNum.peek()){
                rNum.pop();
            }
            if(rNum.empty()){
                answer.insert(0,"-1 ");
            }else{
                answer.insert(0," ").insert(0,rNum.peek());
            }
            rNum.push(cur);
        }
        System.out.println(answer.toString());
    }
}