//BOJ 11049
//2021.11.08
//category: 동적계획법
//review:

import java.io.*;

class Main{
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
        br.close();
    }
}
