//BOJ: 10872
//2021.07.19
//category: 재귀함수 구현
//review:

import java.io.*;
// import java.util.*;

public class Main {
    static int calFactorial(int n){
        if(n==0)return 1;
        return n*calFactorial(n-1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        out.write(calFactorial(n)+"\n");
        out.flush();
    }
}