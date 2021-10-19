//BOJ 1654
//2021.10.19
//category: 이분탐색
//review:

import java.io.*;
import java.util.*;

class Main{
    static int bisearch(Integer[] arr,int target,int start,int end){
        if(start==end){
            if(arr[start]>=target) return start;
            return start-1;
        }
        int mid=(start+end)/2;
        if(arr[mid]==target) return mid;
        if(arr[mid]<target) return bisearch(arr,target,start,mid);
        return bisearch(arr,target,mid+1,end);
    }
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int k=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int n=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        Integer[] arr=new Integer[k];
        for(int i=0;i<k;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int answer=arr[k-1];
        while(true){
            int sum=0;
            for(int i=answer;i<=arr[0];i+=answer){
                sum+=bisearch(arr,i,0,k-1)+1;
            }
            if(sum>=n) break;
            answer--;
        }
        System.out.println(answer);
    }
}