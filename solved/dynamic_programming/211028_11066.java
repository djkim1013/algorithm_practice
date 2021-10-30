//BOJ 11066
//2021.10.28
//category: 동적계획법
//review:

import java.util.*;
import java.io.*;

class Main{
    static int[][] cache;
    static int[] sum;

    static int findMin(int start,int end){
        if(start==end) return 0;
        if(cache[start][end]>0) return cache[start][end];
        int ret=Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            ret=Math.min(ret,findMin(start,i)+findMin(i+1,end));
        }
        return cache[start][end]=ret+sum[end]-sum[start-1];
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            sum=new int[n+1];
            cache=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
            }
            answer.append(findMin(1,n)).append("\n");
        }
        System.out.print(answer);
        br.close();
    }
}