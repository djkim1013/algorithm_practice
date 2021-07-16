//BOJ: 2839
//2021.07.16
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

public class Main {
    static int[] cache = new int[1000];
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<cache.length;i++)Arrays.fill(cache,-1);
        int n = Integer.parseInt(in.readLine());
        int answer=0;
        out.write(answer+"\n");
        out.flush();
    }
}