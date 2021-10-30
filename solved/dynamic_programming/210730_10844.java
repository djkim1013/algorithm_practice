//BOJ: 10844
//2021.07.30
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static final int MOD=1000000000;
    static int[][] cache;
    static int n;
    static int countStair(int order,int pre){
        if(order==n) return 1;
        int ret = cache[order][pre];
        if(ret>-1) return ret;
        ret = 0;
        if(order==0){
            for(int i=1;i<10;i++){
                ret+=countStair(order+1,i);
                ret%=MOD;
            }
            return cache[order][pre] = ret;
        }
        if(pre>0) ret = (ret+countStair(order+1,pre-1))%MOD;
        if(pre<9) ret = (ret+countStair(order+1,pre+1))%MOD;
        return cache[order][pre] = ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        cache=new int[n+1][10];
        for(int i=0;i<=n;i++) Arrays.fill(cache[i],-1);
        System.out.println(countStair(0,0));
    }
}