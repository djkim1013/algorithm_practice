//BOJ: 1436
//2021.07.20
//category: 완전탐색
//review:

import java.io.*;
// import java.util.*;

public class Main {
    static int count666(int n){
        int i=0;
        while(n>0){
            if(Integer.toString(++i).contains("666")) n--;
        }
        return i;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        out.write(count666(n)+"");
        out.flush();
    }
}