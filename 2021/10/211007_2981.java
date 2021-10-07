//BOJ: 2981
//2021.10.07
//category: 정수론 및 조합론
//review:
//      a%m = a - (a/m)*m = b%m = b - (b/m)*m
//      => a-b = (a/m - b/m)*m

import java.util.*;
import java.io.*;

public class Main {
    static int gcf(int a,int b){
        if(a>b) return gcf(b,a);
        if(a>0) return gcf(b%a,a);
        return b;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] numbers=new int[n];
        int min=numbers[0]=Integer.parseInt(br.readLine());
        for(int i=1;i<n;i++){
            numbers[i]=Integer.parseInt(br.readLine());
            if(min>numbers[i]) min=numbers[i];
        }
        Arrays.sort(numbers);
        for(int i=n-1;i>0;i--){
            numbers[i]-=numbers[i-1];
        }
        int g=numbers[1];
        for(int i=2;i<n;i++){
            g=gcf(g,numbers[i]);
        }
        StringBuilder answer=new StringBuilder();
        for(int i=g;i>1;i--){
            if(g%i==0) answer.insert(0,i+" ");
        }
        System.out.println(answer);
    }
}