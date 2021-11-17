//BOJ 10942
//2021.11.17
//category: 동적계획법
//review:

import java.io.*;
import java.util.*;

class Main{
    static int[] arr;
    static int[][] dp;

    static int judgePalindrome(int left, int right){
        if(left >= right) return 1;
        if(dp[left][right] != -1) return dp[left][right];
        if(arr[left] != arr[right]) return dp[left][right] = 0;
        return dp[left][right] = judgePalindrome(left + 1, right - 1);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        int m = Integer.parseInt(br.readLine());
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            bw.write(judgePalindrome(left,right)+'0');
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
