//BOJ: 11047
//2021.10.05
//category: 그리디 알고리즘
//review:

import java.util.*;
import java.io.*;

public class Main {
    int[] coins;

    int countCoins(int n,int rest){
        if(n==0) return rest;
        int ret=rest/coins[n];
        return ret+countCoins(n-1,rest%coins[n]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Main mClass = new Main();
        mClass.coins = new int[n];
        for(int i=0;i<n;i++){
            mClass.coins[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(mClass.countCoins(n-1,k));
    }
}
