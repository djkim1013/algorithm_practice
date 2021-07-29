//BOJ: 2579
//2021.07.29
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] stair;
    static int[][] cache;

    static int maxScore(int idx, int pre){
        if(idx==n) return stair[n];
        if(idx>n) return Integer.MIN_VALUE;
        int ret = cache[idx][pre];
        if(ret>-1) return ret;
        if(idx<=1||pre>0){
            ret=stair[idx]+maxScore(idx+1,0);
        }
        ret=Math.max(stair[idx]+maxScore(idx+2,1),ret);
        cache[idx][pre]=ret;
        return ret;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        cache = new int[n+1][2];
        for(int i=0;i<=n;i++) Arrays.fill(cache[i],-1);
        stair = new int[n+1];
        for(int i=1;i<=n;i++){
            stair[i] = Integer.parseInt(in.readLine());
        }
        System.out.println(maxScore(0,0));
    }
}