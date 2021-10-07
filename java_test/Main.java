//BOJ: 2981
//2021.10.07
//category: 정수론 및 조합론
//review:

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
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            numbers[i]=Integer.parseInt(br.readLine());
            if(min>numbers[i]) min=numbers[i];
        }
        Set<Integer> gcfs=new HashSet<Integer>();
        while(min>1){
            int g=numbers[0]--;
            for(int i=1;i<n;i++){
                g=gcf(numbers[i]--,g);
            }
            if(g>1){
                gcfs.add(g);
            }
            min--;
        }
        StringBuilder answer=new StringBuilder();
        for(int i:gcfs) answer.append(i+" ");
        System.out.println(answer);
    }
}