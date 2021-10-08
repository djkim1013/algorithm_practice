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
        for(int i=m;i<=n;i++){
            int j=i;
            while(j%2==0){
                two++;
                j/=2;
            }
            while(j%5==0){
                five++;
                j/=5;
            }
        }
        for(int i=2;i<=m;i++){
            int j=i;
            while(j%2==0){
                two--;
                j/=2;
            }
            while(j%5==0){
                five--;
                j/=5;
            }
        }
        System.out.println(Math.min(five,two));
    }
}