//BOJ 1520
//2021.11.17
//category: 동적계획법
//review:

import java.io.*;
import java.util.*;

class Main{
    static int m, n;
    static int[][] map;
    static int[][] dp;
    static int[][] nextPath = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    static int countPath(int row,int col){
        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int ret = 0;
        for(int next = 0; next < 4; next++){
            int i = row + nextPath[next][0];
            if(i < 0 || i >= m) continue;
            int j = col + nextPath[next][1];
            if(j < 0 || j >= n) continue;
            if(map[i][j] >= map[row][col]) continue;
            ret += countPath(i, j);
        }
        return dp[row][col] = ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(countPath(0,0));
        br.close();
    }
}
