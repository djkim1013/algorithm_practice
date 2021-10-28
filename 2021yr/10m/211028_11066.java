//BOJ 11066
//2021.10.28
//category: 동적계획법
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] sum=new int[n+1];
            int[][] dp=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                sum[i]=Integer.parseInt(st.nextToken())+sum[i-1];
            }
            for(int len=2;len<n;len++){
                for(int left=1;left+len<=n;left++){
                    int right=left+len;
                    dp[left][right]=Integer.MAX_VALUE;
                    int psum=sum[right]-sum[left-1];
                    for(int mid=left;mid<=right;mid++){
                        dp[left][right]=Math.min(dp[left][right],
                                                dp[left][mid]+dp[mid+1][right]+psum);
                    }
                }
            }
            answer.append(dp[1][n]).append("\n");
        }
        System.out.print(answer);
        br.close();
    }
}
