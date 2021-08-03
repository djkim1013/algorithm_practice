//BOJ: 11047
//2021.08.03
//category: 탐욕법
//review:

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(in.readLine());
        }
	}
}
