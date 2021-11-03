//BOJ 23325 홍대 경진대회 F
//2021.10.30
//category: 다이나믹 프로그래밍
//review:

import java.io.*;
import java.util.*;

class Main{
    static String str;
    static int n,MIN;
    static int cache[][];
    static int maxResult(int idx, int prev){
        if(idx==n){
            if(prev!=0){
                return MIN;
            }
            return 0;
        }
        if(cache[idx][prev+1]!=MIN) return cache[idx][prev+1];
        int ret=MIN;
        if(prev!=0){
            if(str.charAt(idx)=='+'){
                ret=Math.max(prev*10+maxResult(idx+1,0),ret);
                if(idx+1<n&&str.charAt(idx+1)=='-'){
                    ret=Math.max(prev*11+maxResult(idx+2,0),ret);
                }
            }else{
                ret=Math.max(prev+maxResult(idx+1,0),ret);
            }
        }else{
            if(str.charAt(idx)=='+'){
                ret=Math.max(maxResult(idx+1,1),ret);
            }else{
                ret=Math.max(maxResult(idx+1,-1),ret);
            }
        }
        return cache[idx][prev+1]=ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        str=br.readLine();
        n=str.length();
        MIN=-11*n;
        cache=new int[n][3];
        for(int i=0;i<n;i++) Arrays.fill(cache[i],MIN);
        System.out.println(maxResult(0,1));
    }
}