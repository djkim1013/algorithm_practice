//BOJ: 2581
//2021.07.18
//category: 기본수학
//review:
//      -오답: 조건식 등호 누락

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
        int m=Integer.parseInt(in.readLine());
        int n=Integer.parseInt(in.readLine());
        int sum=0;
        int min=0;
        for(int i=m;i<=n;i++){
            if(judgePrime(i)){
                sum+=i;
                if(min==0)min=i;
            }
        }
        if(min==0){
            out.write("-1");
        }else{
            out.write(sum+"\n"+min);
        }
        out.flush();
    }
}