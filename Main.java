//BOJ: 2775
//2021.07.16
//category: 기본수학
//review:
//      - 오류: k,n 범위 오류 방지를 위해 배열을 넉넉하게 잡는다.

import java.io.*;
import java.util.*;

public class Main {
    static int[][] apt = new int[15][15];
    static int countNeighbor(int k, int n){
        if(k==0) return n;
        int ret = apt[k][n];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=1;i<=n;i++){
            ret+=countNeighbor(k-1,i);
        }
        apt[k][n] = ret;
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        for(int i=0;i<14;i++)Arrays.fill(apt[i],-1);
        for(int test=0;test<t;test++){
            int k = Integer.parseInt(in.readLine());
            int n = Integer.parseInt(in.readLine());
            int answer=countNeighbor(k, n);
            out.write(answer+"\n");
        }
        out.flush();
    }
}
