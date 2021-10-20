//BOJ 1654
//2021.10.20
//category: 이분탐색
//review:
//      - 모든 랜선을 사용해야하는 것은 아니다.
//      - 결국 이분탐색이라는 것은 순차적으로 탐색할 시간을 줄이는 것이 관건이다.

import java.io.*;
import java.util.*;

class Main{
    static int sum(Integer[] arr,int mod){
        int sum=0;
        for(int i:arr) sum+=i/mod;
        return sum;
    }
    
    static int maxLen(Integer[] arr,int max,int n){
        int start=1, end=max;
        while(start<end){
            int mid=(int)(((long)start+end)/2);
            if(sum(arr,mid)<n) end=mid;
            else start=mid+1;
        }
        return start;
    }

    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int k=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        Integer[] arr=new Integer[k];
        int max=0;
        for(int i=0;i<k;i++){
            arr[i]=Integer.parseInt(br.readLine());
            max=Math.max(max,arr[i]);
        }
        int answer=maxLen(arr,max,n);
        if(answer<max) answer--;
        System.out.println(answer);
    }
}