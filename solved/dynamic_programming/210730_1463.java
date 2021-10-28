//BOJ: 1463
//2021.07.30
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[] cache;
    static int n;
    static int makeN(int i){
        if(i==1) return 0;
        if(i<=3) return 1;
        int ret = cache[i];
        if(ret>-1) return ret;
        
        ret=1000000;
        
        if(i%3==0) {
            ret=Math.min(makeN(i/3)+1,ret);
        }else {
            ret=Math.min(makeN(i-i%3)+i%3,ret);
        }

        if(i%2==0) ret=Math.min(makeN(i/2)+1,ret);
        else ret=Math.min(makeN(i-1)+1,ret);
        
        cache[i]=ret;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        cache=new int[n+1];
        Arrays.fill(cache,-1);
        System.out.println(makeN(n));
    }
}