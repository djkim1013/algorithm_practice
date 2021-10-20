//BOJ 2805
//2021.10.20
//category: 이분탐색
//review:

import java.io.*;
import java.util.*;

class Main{
    static long cutLen(int[] trees,int height){
        long sum=0;
        for(int i:trees){
            if(i<=height) continue;
            sum+=i-height;
        }
        return sum;
    }
    
    static int minLen(int[] trees,int max,int m){
        int start=0, end=max-1;
        while(start<end){
            int mid=(int)(((long)start+end)/2);
            if(cutLen(trees,mid)<(long)m) end=mid;
            else start=mid+1;
        }
        return start;
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] trees=new int[n];
        st=new StringTokenizer(br.readLine());
        int max=0;
        for(int i=0;i<n;i++){
            trees[i]=Integer.parseInt(st.nextToken());
            max=Math.max(trees[i],max);
        }
        int answer=minLen(trees,max,m);
        System.out.println(answer>0?answer-1:0);
    }
}