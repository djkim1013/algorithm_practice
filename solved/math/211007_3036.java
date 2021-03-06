//BOJ: 
//2021.10.07
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    static int bico(int n, int k){
        if(n==1&&k==1) return 1;
        if(k<0||k>n) return 0;
        return bico(n-1,k-1)+bico(n-1,k);
    }
    public static void main(String[] arg)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parse(input[0]);
        int k = Integer.parse(input[1]);
        System.out.println(bico(n,k));
    }
}
