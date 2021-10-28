//BOJ: 1149
//2021.07.29
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[][] cache;
    static int n;
    static int[][] cost;
    static int rgb(int idx,int pre){
        if(idx==n){
            return 0;
        }
        int ret = cache[idx][pre];
        if(ret>-1) return ret;
        ret = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if(idx>0&&pre==i) continue;
            ret = Math.min(ret, rgb(idx+1,i)+cost[idx][i]);
        }
        cache[idx][pre]=ret;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        cache = new int[n+1][3];
        for(int i=0;i<n;i++) Arrays.fill(cache[i],-1);
        cost = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0;j<3;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(rgb(0,0));
    }
}