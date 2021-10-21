//BOJ 1300
//2021.10.21
//category: 이분탐색
//review:
//      - 2805번 문제와 같은 원리로 풀 수 있다.
//          각 행에서 임의의 수 m 보다 작은 수의 개수는 m/i 와 n 중의 최솟값이다.

import java.io.*;
//import java.util.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        int start=1;
        int end=(int)Math.min((long)n*n,Integer.MAX_VALUE);
        while(start<end){
            int mid=(int)((long)start+end)/2;
            int sum=0;
            for(int i=1;i<=n;i++){
                sum+=Math.min(mid/i,n);
            }
            if(sum==k){
                start=mid;
                break;
            }else if(sum<k) start=mid+1;
            else end=mid-1;
        }
        System.out.println(start);
    }
}