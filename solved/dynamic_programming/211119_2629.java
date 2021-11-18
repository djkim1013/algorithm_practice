//BOJ 2629
//2021.11.19
//category: 동적계획법
//review:

import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[] weights;
    static int[][] dp;

    static int combination(int idx, int remain){
        if(remain == 15000){
            return 1;
        }
        if(idx == n || remain > 30000){
            return 0;
        }
        if(dp[idx][remain] != -1){
            return dp[idx][remain];
        }
        int ret = combination(idx + 1, remain);
        ret |= combination(idx + 1, remain + weights[idx]);
        if(remain >= weights[idx]) ret |= combination(idx + 1, remain - weights[idx]);
        return dp[idx][remain] = ret;
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        int[] beads = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            beads[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[n][30001];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for(int bead : beads){
            bw.write(combination(0, bead + 15000) == 1 ? "Y " : "N ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
