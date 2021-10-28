//BOJ: 1010
//2021.10.08
//category: 정수론 및 조합론
//review:
//      - 동적 계획법으로 해결

import java.util.*;
import java.io.*;

class Main{
    static int[][] cache;
    static int left,right;
    static int countCase(int l,int r){
        if(l==left) return 1;
        if(r==right-left+l) return 1;
        if(cache[l][r]!=-1) return cache[l][r];
        return cache[l][r]=countCase(l+1,r+1)+countCase(l,r+1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder answer=new StringBuilder();
        while(t-->0){
            st=new StringTokenizer(br.readLine()," ");
            left=Integer.parseInt(st.nextToken());
            right=Integer.parseInt(st.nextToken());
            cache=new int[left][right];
            for(int[] arr:cache) Arrays.fill(arr,-1);
            answer.append(countCase(0,0)).append("\n");
        }
        System.out.print(answer);
    }
}