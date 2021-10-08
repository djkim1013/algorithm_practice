//BOJ: 2156
//2021.07.30
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[] glasses;
    static int[][] cache;
    static int n;
    static int maxWine(int idx, int cont){
        if(idx==n){
            return 0;
        }
        int ret = cache[idx][cont];
        if(ret>-1) return ret;
        ret = maxWine(idx+1,0);
        if(cont<2) ret = Math.max(ret,glasses[idx]+maxWine(idx+1,cont+1));
        return cache[idx][cont] = ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        glasses = new int[n];
        cache = new int[n][3];
        for(int i=0;i<n;i++){
            glasses[i] = Integer.parseInt(in.readLine());
            Arrays.fill(cache[i],-1);
        }
        System.out.println(maxWine(0,0));
    }
}