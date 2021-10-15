//BOJ 6549
//2021.10.15
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    static int[] arr;

    static int left(int idx){
        if(idx==0) return 1;
        int ret=0;
        for(int i=idx;i>=0;i--){
            if(arr[i]<arr[idx]) return ret;
            ret++;
        }
        return ret;
    }
    
    static int right(int idx){
        if(idx==arr.length-1) return 0;
        int ret=0;
        for(int i=idx+1;i<arr.length;i++){
            if(arr[i]<arr[idx]) return ret;
            ret++;
        }
        return ret;
    }
    
    static long maxArea(int start,int end){
        if(start==end) return arr[start];
        int mid=(start+end)/2;
        long h=arr[mid];
        long ret=maxArea(start,mid);
        ret=Math.max(ret,maxArea(mid+1,end));
        ret=Math.max(ret,h*(left(mid)+right(mid)));
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        while((input=br.readLine()).charAt(0)!='0'){
            st=new StringTokenizer(input);
            int n=Integer.parseInt(st.nextToken());
            arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
            answer.append(maxArea(0,n-1)).append("\n");
        }
        System.out.print(answer);
    }
}