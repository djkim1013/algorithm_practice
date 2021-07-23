//BOJ: 9663
//2021.07.23
//category: backtracking
//review:
//      - 다차원 배열은 clone()으로는 깊은 복사가 되지 않음 주의
//      - 메모리 초과:

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
            boolean[][] boardNew = new boolean[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    boardNew[i][j] = board[i][j];
            for(int i=0;i<n;i++){
                if(!boardNew[row][i]) boardNew[row][i]=true;
                if(!boardNew[i][col]) boardNew[i][col]=true;
                
                if(row-i>=0&&col-i>=0&&!boardNew[row-i][col-i]) boardNew[row-i][col-i]=true;
                if(row-i>=0&&col+i<n&&!boardNew[row-i][col+i]) boardNew[row-i][col+i]=true;
                if(row+i<n&&col-i>=0&&!boardNew[row+i][col-i]) boardNew[row+i][col-i]=true;
                if(row+i<n&&col+i<n&&!boardNew[row+i][col+i]) boardNew[row+i][col+i]=true;
            }
            ret+=nQueen(row,col+1,count+1,boardNew);
        }
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        System.out.print(nQueen(0,0,0,new boolean[n][n]));
    }
}