//BOJ: 1932
//2021.07.29
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] triangle, cache;
    static int maxPath(int row, int col){
        if(row==n||col==n) return 0;
        int ret = cache[row][col];
        if(ret>-1) return ret;
        ret=triangle[row][col];
        ret+=Math.max(maxPath(row+1,col),maxPath(row+1,col+1));
        cache[row][col]=ret;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        cache = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(cache[i],-1);
        triangle = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0;j<=i;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(maxPath(0,0));
    }
}