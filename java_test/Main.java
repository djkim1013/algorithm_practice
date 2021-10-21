//BOJ 2110
//2021.10.21
//category: 이분탐색
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine())-1;
        long half=((long)n*n+n+1)/2;
        if(k<=half){
            for(int i=n;i>=1;i--){
                half-=i;
                if(half<=k){
                    int j=k-(int)half;
                    System.out.println()
                }
            }
        }else{

        }
    }
}