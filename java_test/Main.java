//BOJ: 2004
//2021.10.08
//category: 정수론 및 조합론
//review:
//      - 1676문제와 다르게 2의 배수가 더 적어지는 경우도 고려해야한다.

import java.util.*;
import java.io.*;

class Main{
    static int countFive(int n){
        int ret=0;
        while(n>=5){
            ret+=n/=5;
        }
        return ret;
    }
    static int countTwo(int n){
        int ret=0;
        while(n>=2){
            ret+=n/=2;
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(input.nextToken());
        int m=Integer.parseInt(input.nextToken());
        int five=countFive(n);
        five-=countFive(m);
        five-=countFive(n-m);
        int two=countTwo(n);
        two-=countTwo(m);
        two-=countTwo(n-m);
        System.out.println(Math.min(two,five));
    }
}