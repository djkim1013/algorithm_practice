//BOJ 2293
//2021.11.21
//category: 동적계획법
//review:

import java.io.*;
import java.util.*;

class Main{
    static int[][] dp;

    static int dfs(int[] coins,int idx,int k){
        if(k == 0) return 1;
        if(idx == coins.length) return 0;
        int ret = dp[idx][k];
        if(ret != -1) return ret;
        ret = 0;
        int value = coins[idx];
        int remain = k;
        while(remain>=0){
            ret += dfs(coins,idx+1,remain);
            remain-=value;
        }
        return dp[idx][k] = ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int k = Integer.parseInt(input.substring(input.indexOf(" ")+1));
        int[] coins = new int[n];
        for(int i=0;i<n;i++) coins[i] = Integer.parseInt(br.readLine());
        dp = new int[n][k+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        Arrays.sort(coins);
        System.out.println(dfs(coins,0,k));
    }
}