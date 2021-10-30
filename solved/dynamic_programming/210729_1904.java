//BOJ: 1904
//2021.07.29
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static final int MOD = 15746;
    static int[] cache = new int[1000001];
    static int makeNum(int n){
        if(n<=2) return n;
        int ret = cache[n];
        if(ret!=-1) return ret;
        ret = makeNum(n-2);
        ret += makeNum(n-1);
        cache[n] = ret %= MOD;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Arrays.fill(cache,-1);
        System.out.print(makeNum(n));
    }
}