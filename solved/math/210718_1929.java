//BOJ: 1929
//2021.07.18
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

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
        StringTokenizer input = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());
        for(int i=m;i<=n;i++){
            if(judgePrime(i))out.write(i+"\n");
        }
        out.flush();
    }
}