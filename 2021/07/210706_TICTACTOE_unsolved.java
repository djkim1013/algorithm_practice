//AOJ: TICTACTOE
//2021.07.06
//문제 분류: 동적계획법
//해결 분석: 

import java.util.*;

public class Main {
	static final int SIZE = 3*3*3*3*3*3*3*3*3;
	static int[] cache = new int[SIZE];
	static int[][] boardInit = new int[3][3];
	
	static int bijection(int[][] board){
		int ret = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				ret *= 3;
				if(board[i][j]<0) ++ret;
				else if(board[i][j]>0) ret+=2;
			}
		}
		return ret;
	}

	static boolean judge(int[][] board,int turn){
		for(int i=0;i<3;i++){
			if((board[i][0]==-turn&&board[i][0]==board[i][1]&&board[i][1]==board[i][2])||
			(board[0][i]==-turn&&board[0][i]==board[1][i]&&board[1][i]==board[2][i]))
				return true;
		}
		if(board[1][1]==-turn&&((board[0][0]==board[1][1]&&board[1][1]==board[2][2])||
		(board[0][2]==board[1][1]&&board[1][1]==board[2][0])))
			return true;
		return false;
	}

	static int playGame(int turn, int[][] board){
		if(judge(board,turn)) {
			return -1;
		}
		int ret = cache[bijection(board)];
		if(ret!=-2) return ret;
		ret = 2;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]!=0) continue;
				int[][] boardCp = board.clone();
				boardCp[i][j] = turn;
				ret = Math.min(ret,playGame(-turn,boardCp));
			}
		}
		if(ret==0||ret==2) {
			ret = 0;
		}else{
			ret *= -1;
		}
			cache[bijection(board)] = ret;
		return ret;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int ci=0;ci<c;ci++){
			int turn = 1;
			Arrays.fill(cache,-2);

			for(int i=0;i<3;i++){
				String row = sc.next();
				for(int j=0;j<3;j++){
					char space = row.charAt(j);
					if(space=='x'){
						boardInit[i][j]=1;
						turn*=-1;
					} 
					else if(space=='o') {
						boardInit[i][j]=-1;
						turn*=-1;
					}
					else boardInit[i][j] = 0;
				}

			}

			int winner = playGame(turn,boardInit);
			String answer="TIE";
			if(winner==1) answer="x";
			else if(winner==-1) answer="o";
			System.out.println(answer);
		}
		sc.close();
	}
}
