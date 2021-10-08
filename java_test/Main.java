//BOJ: 2004
//2021.10.08
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(input.nextToken());
        int m=Integer.parseInt(input.nextToken());
        int two=0, five=0;
        for(int i=2;i<=n;i++){
            int j=i;
            int t=0, f=0;
            while(j%2==0){
                t++;
                j/=2;
            }
            while(j%5==0){
                f++;
                j/=5;
            }
            if(i>m){
                two+=t;
                five+=f;
            }
            if(i<=n-m){
                two-=t;
                five-=f;
            }
        }
        System.out.println(Math.min(five,two));
    }
}