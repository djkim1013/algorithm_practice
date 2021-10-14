//BOJ 2740
//2021.10.14
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int aRow=Integer.parseInt(st.nextToken());
        int aCol=Integer.parseInt(st.nextToken());
        int[][] matrixA=new int[aRow][aCol];
        StringBuilder answer=new StringBuilder();
        
        for(int i=0;i<aRow;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<aCol;j++){
                matrixA[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        st=new StringTokenizer(br.readLine());
        st.nextToken();
        int bCol=Integer.parseInt(st.nextToken());
        int[][] matrixB=new int[aCol][bCol];
        int[][] matrixSum=new int[aRow][bCol];
        
        for(int i=0;i<aCol;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<bCol;j++){
                matrixB[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<aRow;i++){
            for(int j=0;j<bCol;j++){
                for(int k=0;k<aCol;k++){
                    matrixSum[i][j]+=matrixA[i][k]*matrixB[k][j];
                }
            }
        }
        
        for(int[] row:matrixSum){
            for(int i:row){
                answer.append(i).append(" ");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}