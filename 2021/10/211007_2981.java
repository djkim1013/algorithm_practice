//BOJ: 2981
//2021.10.07
//category: 정수론 및 조합론
//review:
//      a%m = a - (a/m)*m = b%m = b - (b/m)*m
//      => a-b = (a/m - b/m)*m
//      * 약수는 대칭으로 곱하면 대상인 수가 된다.

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
        for(int i=0;i<n;i++){
            numbers[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i+1<n;i++){
            numbers[i]-=numbers[i+1];
            if(numbers[i]<0) numbers[i]*=-1;
        }
        int g=numbers[0];
        for(int i=1;i+1<n;i++){
            g=gcf(g,numbers[i]);
        }
        ArrayList<Integer> answerList=new ArrayList<Integer>();
        for(int i=2;i*i<=g;i++){
            if(g%i==0){
                answerList.add(i);
                if(g/i!=i) answerList.add(g/i);
            }
        }
        answerList.add(g);
        Collections.sort(answerList);
        StringBuilder answer=new StringBuilder();
        for(int i:answerList) answer.append(i+" ");
        System.out.println(answer);
    }
}