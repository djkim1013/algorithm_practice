//BOJ: 2231
//2021.07.20
//category: 완전탐색
//review:
//      - 오답: 답이 없는 경우 누락

import java.io.*;
// import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int a=0, b=0, c=0;
        while(a<10){
            while(b<10){
                while(c<10){
                    if(a*101+b*11+c*2==n){
                        out.write((a*100+b*10+c)+"\n");
                        a=10;
                        b=10;
                        c=10;
                    }
                    c++;
                }
                b++;
                c=0;
            }
            a++;
            b=0;
            c=0;
        }
        out.flush();
    }
}