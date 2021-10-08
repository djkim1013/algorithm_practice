//BOJ: 2004
//2021.10.08
//category: 정수론 및 조합론
//review:


import java.util.*;
import java.io.*;

class Main{
    static long countFive(long n){
        long ret=0;
        while(n>=5){
            ret+=n/=5;
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input=new StringTokenizer(br.readLine());
        long n=Long.parseLong(input.nextToken());
        long m=Long.parseLong(input.nextToken());
        System.out.println(countFive(n)-countFive(m)-countFive(n-m));
    }
}