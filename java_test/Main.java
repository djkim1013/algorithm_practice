//BOJ 10830
//2021.10.14
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] a;
    static int[][] multiple(int[][] a,int[][] b){
        int[][] ret=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    ret[i][j]+=a[i][k]*b[k][j]%1000;
                    ret[i][j]%=1000;
                }
            }
        }
        return ret;
    }
    static int[][] power(int[][] matrix,long b){
        if(b==1) return matrix;
        if(b==0){
            int[][] ret=new int[n][n];
            for(int i=0;i<n;i++) ret[i][i]=1;
            return ret;
        }
        long l=1;
        for(;l*2<b;l*=2){
            matrix=multiple(matrix,matrix);
        }
        return multiple(matrix,power(a,b-l));
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        int[][] matrix=new int[n][n];
        a=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
                matrix[i][j]=a[i][j];
            }
        }
        matrix=power(a,b);
        StringBuilder answer=new StringBuilder();
        for(int[] row:matrix){
            for(int i:row) answer.append(i).append(" ");
            answer.append("\n");
        }
        System.out.print(answer);
    }
}