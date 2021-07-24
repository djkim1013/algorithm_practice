//BOJ: 9663
//2021.07.23
//category: backtracking
//review:
//      - 다차원 배열은 clone()으로는 깊은 복사가 되지 않음 주의
//      - 메모리 초과: 재귀함수에서 필요없는 계산 제거

// import java.util.*;
import java.io.*;

public class Main{
    static int n;
    boolean boardCheck(int row, int idx, int[] board){
        for(int i=0;i<row;i++){
            if(board[i]==idx) return false;
            if(board[i]+row-i==idx) return false;
            if(board[i]-row+i==idx) return false;
        }
        return true;
    }
    int nQueen(int row,int[] board){
        if(row==n){
            return 1;
        }
        int ret = 0;
        for(int i=0;i<n;i++){
            if(!boardCheck(row,i,board))continue;
            int[] boardNew = board.clone();
            boardNew[row]=i;
            ret+=nQueen(row+1,boardNew);
        }
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        Main m = new Main();
        System.out.print(m.nQueen(0,new int[n]));
    }
}