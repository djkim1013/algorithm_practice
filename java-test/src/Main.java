//BOJ 2293
//2021.11.21
//category: 동적계획법
//review:

import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int k = Integer.parseInt(input.substring(input.indexOf(" ")+1));
        int[] coins = new int[n];
        for(int i=0;i<n;i++) coins[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[k+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            int value = coins[i];
            for(int j=1;j<=k;j++){
                if(j>=value) dp[j] += dp[j-value];
            }
        }
        System.out.println(dp[k]);
        br.close();
    }
}