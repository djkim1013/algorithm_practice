//BOJ: 4948
//2021.07.18
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
        int n=0;
        while((n=Integer.parseInt(in.readLine()))!=0){
            int answer=0;
            for(int i=n+1;i<=2*n;i++){
                if(judgePrime(i))answer++;
            }
            out.write(answer+"\n");
        }
        out.flush();
    }
}