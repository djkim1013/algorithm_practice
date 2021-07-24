//BOJ: 9663
//2021.07.25
//category: backtracking
//review:
//      - 다차원 배열은 clone()으로는 깊은 복사가 되지 않음 주의
//      - 메모리 초과: 재귀함수에서 필요없는 계산 제거
//      - 메모리 초과: 좌우 반전 상은 계산 건너뛰기
//      - 메모리 초과: 자바에서 1차원 배열전달은 항상 값에 의한 전달이므로 배열을 복사할 필요 없다.

// import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static boolean boardCheck(int row, int idx, int[] board){
        for(int i=0;i<row;i++){
            if(board[i]==idx) return false;
            if(board[i]+row-i==idx) return false;
            if(board[i]-row+i==idx) return false;
        }
        return true;
    }
    static int nQueen(int row,int[] board){
        if(row==n){
            return 1;
        }
        int ret = 0;
        if(row==0){
            for(int i=0;i<n/2;i++){
                board[row]=i;
                ret+=nQueen(row+1,board);
            }
            ret*=2;
            if(n%2>0){
                board[row]=n/2;
                ret+=nQueen(row+1,board);
            }
            return ret;
        }
        for(int i=0;i<n;i++){
            if(!boardCheck(row,i,board)) continue;
            board[row]=i;
            ret+=nQueen(row+1,board);
        }
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        System.out.print(nQueen(0,new int[n]));
    }
}