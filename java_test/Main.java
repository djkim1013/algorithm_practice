//BOJ: 2004
//2021.10.08
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    static int countTwo(int n){
        int ret=0;
        while(n>=2){
            if(n%2==0){
                ret++;
                n/=2;
            }
        }
        return ret;
    }
    
    static int countFive(int n){
        int ret=0;
        while(n>=5){
            if(n%5==0){
                ret++;
                n/=5;
            }
        }
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(input.nextToken());
        int m=Integer.parseInt(input.nextToken());
        int two=0, five=0;
        for(int i=2;i<=n;i++){
            two+=countTwo(i);
            five+=countFive(i);
        }
        for(int i=2;i<=m;i++){
            two-=countTwo(i);
            five-=countFive(i);
        }
        for(int i=2;i<=n-m;i++){
            two-=countTwo(i);
            five-=countFive(i);
        }
        System.out.println(Math.min(five,two));
    }
}