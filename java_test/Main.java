//BOJ 10830
//2021.10.14
//category: 분할정복
//review:

//import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        long b=Long.parseLong(input[1]);
        int[][] a=new int[n][n], matrix=new int[n][n];
        for(int i=0;i<n;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(input[j]);
            }
            matrix[i][i]=1;
        }
        StringBuilder answer=new StringBuilder();
        while(b-->0){
            int[][] temp=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    for(int k=0;k<n;k++){
                        temp[i][j]+=matrix[i][k]*a[k][j]%1000;
                        temp[i][j]%=1000;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    temp[j][i]=temp[i][j];
                }
            }
            matrix=temp;
        }
        for(int[] row:matrix){
            for(int i:row) answer.append(i).append(" ");
            answer.append("\n");
        }
        System.out.print(answer);
    }
}