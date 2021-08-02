//AOJ: TICTACTOE
//2021.08.02
//category: 동적계획법
//review:
//      -초기화 항상 주의!

import java.util.*;
import java.io.*;

public class Main {
    static int[] cache = new int[3*3*3*3*3*3*3*3*3];
	static int[][] board = new int[3][3];

    static int bijection(int[][] board){
        int ret = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ret *= 3;
                ret += board[i][j];
            }
        }
        return ret;
    }
    
    static boolean judge(int[][] board, int turn){
        for(int i=0;i<3;i++){
            if(board[i][0]==turn&&board[i][0]==board[i][1]&&board[i][0]==board[i][2]){
                return true;
            }
            if(board[0][i]==turn&&board[0][i]==board[1][i]&&board[0][i]==board[2][i]){
                return true;
            }
        }
        if(board[1][1]==turn){
            if(board[0][0]==turn&&board[0][0]==board[2][2]){
                return true;
            }
            if(board[0][2]==turn&&board[0][2]==board[2][0]){
                return true;
            }
        }
        return false;
    }

    static int canWin(int[][] board, int turn){
        if(judge(board,turn>1?1:2)) return -1;
        int boardTri = bijection(board);
        int ret = cache[boardTri];
        if(ret>-2) return ret;
        ret = 2;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    board[i][j]=turn;
                    ret=Math.min(ret,canWin(board,turn>1?1:2));
                    board[i][j]=0;
                }
            }
        }
        if(ret==2||ret==0) return cache[boardTri]=0;
        return cache[boardTri]=-ret;

    }
	public static void main(String[] args) throws Exception {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bin.readLine());
        for(int t = 0; t < test; t++){
            int turn = 1;
            for(int i=0;i<3;i++){
                String line = bin.readLine();
                for(int j=0;j<3;j++){
                    if(line.charAt(j)=='x'){
                        board[i][j]=1;
                        turn++;
                    }else if(line.charAt(j)=='o'){
                        board[i][j]=2;
                        turn--;
                    }else{
                        board[i][j]=0;
                    }
                }
            }
            Arrays.fill(cache,-2);
            int answer = canWin(board,turn);
            if(answer==0){
                System.out.println("TIE");
            }else if(answer==1){
                System.out.println(turn>1?'o':'x');
            }else{
                System.out.println(turn>1?'x':'o');
            }
        }
	}
}
