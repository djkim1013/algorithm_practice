//BOJ 6549
//2021.10.16
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    static int[] arr;
    static long maxArea(int start,int end){
        if(start==end) return arr[start];
        int mid=(start+end)/2;
        int s=mid, e=mid+1;
        long h=Math.min(arr[mid],arr[mid+1]);
        long ret=maxArea(start,mid);
        ret=Math.max(ret,maxArea(mid+1,end));
        ret=Math.max(ret,h*2);
        while(s>start||e<end){
            if(s>start&&(e==end||arr[s-1]>arr[e+1])){
                h=Math.min(h,arr[--s]);
            }else{
                h=Math.min(h,arr[++e]);
            }
            ret=Math.max(ret,h*(e-s+1));
        }
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        while(true){
            String input=br.readLine();
            if(input.charAt(0)=='0') break;
            StringTokenizer st=new StringTokenizer(input);
            int n=Integer.parseInt(st.nextToken());
            arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
            answer.append(maxArea(0,n-1)).append("\n");
        }
        System.out.print(answer);
    }
}