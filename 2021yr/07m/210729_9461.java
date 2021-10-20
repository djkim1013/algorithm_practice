//BOJ: 9461
//2021.07.29
//category: dynamic programming
//review:
//      - 오답: stack overflow 주의

import java.util.*;
import java.io.*;

public class Main{
    static int[] cache = new int[101];
    static int padovan(int n){
        if(n==0) return 0;
        if(n<=2) return 1;
        int ret = cache[n];
        if(ret!=-1) return ret;
        ret = padovan(n-3);
        ret += padovan(n-2);
        cache[n] = ret;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(in.readLine());
        Arrays.fill(cache,-1);
        for(int t=0;t<test;t++){
            int n = Integer.parseInt(in.readLine());
            System.out.print(padovan(n)+"\n");
        }
    }
}