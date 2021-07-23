//BOJ: 9663
//2021.07.23
//category: backtracking
//review:

// import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int nQueen(int row,int col,int count,boolean[][] board){
        if(count==n){
           return 1; 
        }
        if(row==n){
            return 0;
        }
        if(col==n){
            return nQueen(row+1,0,count,board);
        }
        int ret = 0;
        ret += nQueen(row,col+1,count,board);
        if(!board[row][col]){
            for(int i=0;i<n;i++){
                if(!board[row][i]) board[row][i]=true;
                if(!board[i][col]) board[i][col]=true;
            }
            for(int i=)
        }
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        System.out.print(nQueen(0,0,0,new boolean[n][n]));
    }
}