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
        int[] cache=new int[n+1];
        for(int i=2;i<=n;i++){
            if(i%2==0){
                cache[i]=cache[i/2]+1;
                two+=cache[i];
            }
        }
        for(int i=2;i<=n;i++){
            two-=cache[i];
            if(i<=n-m) two-=cache[i];
        }
        cache=new int[n+1];
        for(int i=5;i<=n;i++){
            if(i%5==0){
                cache[i]=cache[i/2]+1;
                five+=cache[i];
            }
        }
        for(int i=5;i<=n;i++){
            five-=cache[i];
            if(i<=n-m) five-=cache[i];
        }
        System.out.println(Math.min(five,two));
    }
}