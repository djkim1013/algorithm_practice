//BOJ 2630
//2021.10.13
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] answer=new int[2];
    static int[][] paper;

    static void cut(int c,int r,int len){
        if(len==1){
            answer[paper[c][r]]++;
            return;
        }
        int first=paper[c][r];
        for(int i=c;i<c+len;i++){
            for(int j=r;j<r+len;j++){
                if(paper[i][j]!=first){
                    int lenNext=len/2;
                    cut(c,r,lenNext);
                    cut(c+lenNext,r,lenNext);
                    cut(c,r+lenNext,lenNext);
                    cut(c+lenNext,r+lenNext,lenNext);
                    return;
                }
            }
        }
        answer[paper[c][r]]++;
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
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}