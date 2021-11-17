//BOJ 1520
//2021.11.17
//category: 동적계획법
//review:

import java.io.*;
import java.util.*;

class Main{
    static int m, n;
    static int[][] map;
    static int[][] nextPath = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    static int countPath(int row,int col,int value){
        if(row < 0 || row >= m) return 0;
        if(col < 0 || col >= n) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(map[row][col] >= value) return 0;
        value = map[row][col];
        int ret = 0;
        for(int[] next:nextPath){
            int i = next[0], j = next[1];
            ret += countPath(row + i, col + j, value);
        }
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(countPath(0,0,10001));
        br.close();
    }
}
