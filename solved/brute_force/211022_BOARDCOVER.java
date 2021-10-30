//AOJ BOARDCOVER
//2021.10.22
//category: 
//review:
//      - 설계부터 차근차근히

import java.io.*;
import java.util.*;

class Main{
    static int h,w;
    static int[][] blocks=new int[][]{{0,1,1,0},{0,1,1,1},{1,0,1,1},{1,0,1,-1}};

    static boolean check(int[][] board,int r,int c){
        if(r<0||r>=h) return false;
        if(c<0||c>=w) return false;
        if(board[r][c]==1) return false;
        return true;
    }

    static int coverBoard(int[][] board,int r,int c){
        if(r==h) return 1;
        if(c==w) return coverBoard(board,r+1,0);
        if(board[r][c]==1) return coverBoard(board,r,c+1);;
        int ret=0;
        for(int[] b:blocks){
            int i1=b[0],j1=b[1],i2=b[2],j2=b[3];
            if(check(board,r+i1,c+j1)&&check(board,r+i2,c+j2)){
                board[r][c]=1;
                board[r+i1][c+j1]=1;
                board[r+i2][c+j2]=1;
                ret+=coverBoard(board,r,c+1);
                board[r][c]=0;
                board[r+i1][c+j1]=0;
                board[r+i2][c+j2]=0;
            }
        }
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        int c=Integer.parseInt(br.readLine().trim());
        while(c-->0){
            StringTokenizer st=new StringTokenizer(br.readLine().trim());
            h=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            int[][] board=new int[h][w];
            for(int i=0;i<h;i++){
                String input=br.readLine();
                for(int j=0;j<w;j++){
                    if(input.charAt(j)=='#') board[i][j]=1;
                }
            }
            answer.append(coverBoard(board,0,0)).append("\n");
        }
	    System.out.print(answer);
    }
}