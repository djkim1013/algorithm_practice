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
        int[] rNum=new int[n];
        int[] nge=new int[n];
        int top=-1;
        for(int i=n-1;i>=0;i--){
            int cur=arr[i];
            while(top>=0&&cur>=rNum[top]){
                top--;
            }
            if(top<0){
                nge[i]=-1;
            }else{
                nge[i]=rNum[top];
            }
            rNum[++top]=cur;
        }
        StringBuilder answer=new StringBuilder();
        for(int i:nge) answer.append(i).append(" ");
        System.out.println(answer);
    }
}