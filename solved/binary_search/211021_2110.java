//BOJ 2110
//2021.10.21
//category: 이분탐색
//review:
//      - 가능한 경우의 수를 먼저 세는것이 아니라, 최소 거리에 맞춰 설치 후 가능여부를 본다.

import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[] house;
    
    static int maxDist(int c){
        int start=1,end=house[n-1]-house[0]+1;
        while(start<end){
            int mid=(int)(((long)start+end)/2);
            int sum=1;
            int prev=house[0];
            for(int i=1;i<n;i++){
                if(house[i]-prev>=mid){
                    prev=house[i];
                    sum++;
                }
            }
            if(sum>=c) start=mid+1;
            else end=mid;
        }
        return start-1;
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        house=new int[n];
        for(int i=0;i<n;i++){
            house[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        System.out.println(maxDist(c));
    }
}