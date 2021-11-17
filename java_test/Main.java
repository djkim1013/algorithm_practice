<<<<<<< HEAD
//BOJ 1520
//2021.11.17
=======
//BOJ 11049
//2021.11.10
>>>>>>> c52bbf7b3bb0d51a4f12bce92e493cc0a421199c
//category: 동적계획법
//review:

import java.io.*;
import java.util.*;

class Main{
<<<<<<< HEAD
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
=======
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] size=new int[n+1][2];
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            String input=br.readLine();
            size[i][0]=Integer.parseInt(input.substring(0,input.indexOf(" ")));
            size[i][1]=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        }
        for(int len=1;len<n;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len;
                int temp=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    temp=Math.min(
                        temp,
                        dp[i][k]+dp[k+1][j]+size[i][0]*size[k][1]*size[j][1]
                    );
                }
                dp[i][j]=temp;
            }
        }
        System.out.println(dp[1][n]);
>>>>>>> c52bbf7b3bb0d51a4f12bce92e493cc0a421199c
        br.close();
    }
}
