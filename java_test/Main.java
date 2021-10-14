//BOJ 11401
//2021.10.13
//category: 분할정복
//review:
//      - 페르마의 소정리: (a^p)%p = a%p, (a*(a^(p-2))%p)%p = 1%p
//      => (n!/(k!(n-k)!))%p = (n!%p*(k!(n-k)!)^-1%p)%p
//                           = (n!%p*(k!(n-k)!)^(p-2)%p)%p

//import java.util.*;
import java.io.*;

class Main{
    static final int MOD=1000000007;
    
    static long nFactMod(int n){
        long ret=n;
        while(n-->1){
            ret=(ret*n)%MOD;
        }
        return (int)ret;
    }

    static long powMod(long n,int k){
        if(k==1) return n%MOD;
        if(k==0) return 1;
        long ret=powMod(n,k/2)%MOD;
        ret=ret*ret%MOD;
        if(k%2==1) ret=ret*n%MOD;
        return ret;
    }

    public static void main(String[] args)throws Exception{
        String input=(new BufferedReader(new InputStreamReader(System.in))).readLine();
        int n=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int k=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        long answer=nFactMod(k);
        answer=answer*nFactMod(n-k)%MOD;
        answer=powMod(answer,MOD-2);
        answer=answer*nFactMod(n)%MOD;
        System.out.println(answer);
    }
}