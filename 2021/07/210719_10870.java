//BOJ: 10870
//2021.07.19
//category: 재귀함수 구현
//review:

import java.io.*;
// import java.util.*;

public class Main {
    static int calFibonacci(int n){
        if(n<2)return n;
        return calFibonacci(n-1)+calFibonacci(n-2);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        out.write(calFibonacci(n)+"\n");
        out.flush();
    }
}