//AOJ: NUMBERGAME
//2021.08.18
//category: 동적계획법
//review:
//      -아무것도 고르지 않는 경우 조심
//      -"minimax"

import java.util.*;
import java.io.*;

public class Main {
	static int[] board = new int[50];
    static int[][] cache = new int[50][50];

    static int maxScore(int left, int right){
        if(left>right) return 0;
        int result = cache[left][right];
        if (result != -50001) return result;
        result = Math.max(board[left]-maxScore(left+1,right), board[right]-maxScore(left,right-1));
        if(left<right){
            result = Math.max(result, -maxScore(left+2,right));
            result = Math.max(result, -maxScore(left,right-2));
        }
        return cache[left][right] = result;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t < test; t++){
            int length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<50;i++) Arrays.fill(cache[i],-50001);
            for(int i = 0; i < length; i++){
                board[i]=Integer.parseInt(st.nextToken());
            }
            System.out.println(maxScore(0,length-1));
        }
	}
}
