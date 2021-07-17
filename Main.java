//BOJ: 2581
//2021.07.18
//category: 기본수학
//review:

import java.io.*;
// import java.util.*;

public class Main {
    static int judgePrime(int n){
        if(n==1)return 0;
        for(int i=2;i<(int)Math.sqrt(n);i++){
            if(n%i==0)return 0;
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int m=Integer.parseInt(in.readLine());
        int n=Integer.parseInt(in.readLine());
        int sum=0;
        int min=0xf0000;
        for(int i=m;i<=n;i++){
            int number=judgePrime(i);
            sum+=number;
            if(number>0)min=Math.min(min,number);
        }
        if(min==0xf0000){
            out.write("-1");
        }else{
            out.write(sum+"\n"+min);
        }
        out.flush();
    }
}