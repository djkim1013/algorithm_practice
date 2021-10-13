//BOJ 11401
//2021.10.13
//category: 분할정복
//review:

//import java.util.*;
import java.io.*;

class Main{
    static final int MOD=1000000007;
    static int bico(int n,int k){
        if(k<0||k>n) return 0;
        if(k==0||k==n) return 1;
        if(k>n/2) return bico(n,n-k);
        return (bico(n-1,k)+bico(n-1,k-1))%MOD;
    }
    public static void main(String[] args)throws Exception{
        String input=(new BufferedReader(new InputStreamReader(System.in))).readLine();
        int n=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int k=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        System.out.println(bico(n,k));
    }
}