//NHN pre-test 기출문제
//2021.10.11
//category: 스택
//review:

import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int getArea(int[][] matrix,int i,int j){
        matrix[i][j]=0;
        int ret=1;
        if(i+1<n&&matrix[i+1][j]>0) ret+=getArea(matrix,i+1,j);
        if(j+1<n&&matrix[i][j+1]>0) ret+=getArea(matrix,i,j+1);
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        int[][] matrix=new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer> answer=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]>0){
                    answer.add(getArea(matrix,i,j));
                }
            }
        }
        System.out.println(answer.size());
        if(answer.size()>0){
            Collections.sort(answer);
            StringBuilder output=new StringBuilder(answer.get(0).toString());
            for(int i=1;i<answer.size();i++){
                output.append(" ").append(answer.get(i));
            }
            System.out.println(output);
        }
    }
}