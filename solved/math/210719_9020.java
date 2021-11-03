//BOJ: 9020
//2021.07.19
//category: 기본수학
//review:

import java.io.*;
// import java.util.*;

public class Main {
    static boolean judgePrime(int n){
        if(n==1)return false;
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(in.readLine());
        for(int t=0;t<test;t++){
            int n = Integer.parseInt(in.readLine());
            int p = n/2;
            while(!judgePrime(p)||!judgePrime(n-p)) p--;
            out.write(p+" "+(n-p));
            out.newLine();
        }
        out.flush();
    }
}