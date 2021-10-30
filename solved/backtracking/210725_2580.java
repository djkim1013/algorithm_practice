//BOJ: 2580
//2021.07.25
//category: backtracking
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[] board;
    static boolean checkBox(int cur,int num){
        int row = cur/9;
        int col = cur%9;
        for(int i=0;i<9;i++){
            if(board[row*9+i]==num) return false;
            if(board[i*9+col]==num) return false;
        }
        int areaRow = 3*(row/3);
        int areaCol = 3*(col/3);
        for(int i=areaRow;i<areaRow+3;i++){
            for(int j=areaCol;j<areaCol+3;j++){
                if(board[i*9+j]==num) return false;
            }
        }
        return true;
    }
    static boolean fillBoard(){
        int cur = -1;
        while(++cur<81) if(board[cur]==0) break;
        if(cur==81) return true;
        for(int i=1;i<=9;i++){
            if(checkBox(cur,i)){
                board[cur]=i;
                if(fillBoard()) return true;
                board[cur]=0;
            }
        }
        return false;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        board=new int[9*9];
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int j=0;j<9;j++)
                board[9*i+j]=Integer.parseInt(st.nextToken());
        }
        if(!fillBoard()){
            System.out.println("something wrong");
            return;
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[9*i+j]+" ");
            }
            System.out.println();
        }
    }
}