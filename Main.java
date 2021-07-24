//BOJ: 9663
//2021.07.23
//category: backtracking
//review:
//      - 다차원 배열은 clone()으로는 깊은 복사가 되지 않음 주의
//      - 메모리 초과: 당연한 경우의 수 체크가 많음

// import java.util.*;
import java.io.*;

public class Main{
    static int n;
    int nQueen(int row,int col,int count,int[] board){
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
        if((board[row]&(1<<col))==0){
            int[] boardNew = board.clone();
            for(int i=0;i<n;i++){
                if((boardNew[row]&(1<<i))==0) boardNew[row]+=1<<i;
                if((boardNew[i]&(1<<col))==0) boardNew[i]+=1<<col;
                
                if(row-i>=0&&col-i>=0&&(boardNew[row-i]&(1<<(col-i)))==0) boardNew[row-i]+=1<<(col-i);
                if(row-i>=0&&col+i<n&&(boardNew[row-i]&(1<<(col+i)))==0) boardNew[row-i]+=1<<(col+i);
            }
            ret+=nQueen(row+1,0,count+1,boardNew);
        }
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        Main m = new Main();
        System.out.print(m.nQueen(0,0,0,new int[n]));
    }
}