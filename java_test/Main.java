//AOJ: SORTGAME
//2021.09.29
//category: 그래프의 너비 우선 탐색
//review:

import java.util.*;
import java.io.*;

public class Main {


    //원래자리가 가장 먼 수 찾기
    int findFarthest(int[] arr){
        int idx=0;
        int maxDist=arr[0];
        for(int i=0;i<arr.length;i++){
            int dist=arr[i]>i?arr[i]-i:i-arr[i];
            if(dist>maxDist){
                idx=i;
                maxDist=dist;
            }
        }
        if(maxDist==0) return -1;
        return idx;
    }

    //원래자리가 가장 먼 수를 제자리로 뒤집기
    int countFlip(int[] arr){
        int ret=0;
        int s,e;
        while((s=findFarthest(arr))!=-1){
            if(s>arr[s]){
                e=s;
                s=arr[e];
            }else{
                e=arr[s];
            }
            arr=flip(arr,s,e);
            ret++;
        }
        return ret;
    }

    //뒤집기
    int[] flip(int[] arr,int start, int end){
        for(int i=0;i<(start-end+1)/2;i++){
            int temp=arr[start+i];
            arr[start+i]=arr[end-i];
            arr[end-i]=temp;
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        Main m=new Main();
        while(c-->0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
            System.out.println(m.countFlip(arr));
        }
    }
}
