//BOJ 1654
//2021.10.20
//category: 이분탐색
//review:
//      - 모든 랜선을 사용해야하는 것은 아니다.
//      - 결국 이분탐색이라는 것은 순차적으로 탐색할 시간을 줄이는 것이 관건이다.

import java.io.*;
//import java.util.*;

class Main{
    static int maxLen(Integer[] arr,int n,int start,long end){
        if(start==end){
            return start;
        }
        int mid=(int)((long)start+end)/2;
        int sum=0;
        for(int i:arr) sum+=i/mid;
        if(sum<n) return maxLen(arr,n,start,mid);
        return maxLen(arr,n,mid+1,end);
    }

    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int k=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int n=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        Integer[] arr=new Integer[k];
        int max=0;
        for(int i=0;i<k;i++){
            arr[i]=Integer.parseInteger(br.readLine());
            max=Math.max(max,arr[i]);
        }
        int answer=maxLen(arr,n,1,max);
        if(answer<max) answer--;
        System.out.println(answer);
    }
}