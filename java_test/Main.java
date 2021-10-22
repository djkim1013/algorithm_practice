//BOJ 12015
//2021.10.22
//category: 이분탐색
//review:

import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[] cache;

    static int maxLen(int[] arr,int idx){
        if(idx==n-1) return 1;
        if(cache[idx]!=-1) return cache[idx];
        int ret=0;
        for(int i=idx;i<n;i++){
            if(arr[i]>arr[idx]) ret=Math.max(ret,maxLen(arr,i));
        }
        return cache[idx]=ret+1;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        cache=new int[n];
        Arrays.fill(cache,-1);
        System.out.println(maxLen(arr,0));
    }
}