//BOJ: 11653
//2021.07.18
//category: 기본수학
//review:

import java.io.*;
// import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        while(n>1){
            int m = 1;
            while(++m<n){
                if(n%m==0)break;
            }
            out.write(m+"\n");
            n/=m;
        }
        out.flush();
    }
}