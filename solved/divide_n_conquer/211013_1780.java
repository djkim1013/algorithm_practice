//BOJ 1780
//2021.10.13
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] paper;
    static int[] answer=new int[3];

    static void cut(int c,int r,int len){
        int first=paper[c][r];
        for(int i=c;i<c+len;i++){
            for(int j=r;j<r+len;j++){
                if(paper[i][j]!=first){
                    len/=3;
                    for(int k=0;k<3;k++){
                        for(int l=0;l<3;l++){
                            cut(c+k*len,r+l*len,len);
                        }
                    }
                    return;
                }
            }
        }
        answer[first+1]++;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        paper=new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        cut(0,0,n);
        for(int i:answer) System.out.println(i);
    }
}