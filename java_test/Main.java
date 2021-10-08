//BOJ: 2004
//2021.10.08
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    static int[] twoCache,fiveCache;

    static int countFive(int n){
        if(n<=0) return 0;
        if(n==5) return 1;
        if(fiveCache[n]!=-1) return fiveCache[n];
        if(n%5==0) return fiveCache[n]=countFive(n/5)+1;
        return fiveCache[n]=0;
    }

    static int countTwo(int n){
        if(n<=0) return 0;
        if(n==2) return 1;
        if(twoCache[n]!=-1) return twoCache[n];
        if(n%2==0) return twoCache[n]=countTwo(n/2)+1;
        return twoCache[n]=0;
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(input.nextToken());
        int m=Integer.parseInt(input.nextToken());
        twoCache=new int[n+1];
        fiveCache=new int[n+1];
        Arrays.fill(twoCache,-1);
        Arrays.fill(fiveCache,-1);
        int five=0, two=0;
        for(int i=0;i<=n;i++){
            five+=countFive(i);
            two+=countTwo(i);
        }
        for(int i=0;i<=m;i++){
            five-=countFive(i);
            two-=countTwo(i);
        }
        for(int i=0;i<=n-m;i++){
            five-=countFive(i);
            two-=countTwo(i);
        }
        System.out.println(Math.min(five,two));
    }
}