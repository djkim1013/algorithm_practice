//BOJ: 3036
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
        int[] numbers=new int[n-1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int first=Integer.parseInt(st.nextToken());
        for(int i=0;i<n-1;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }
        StringBuilder answer=new StringBuilder();
        for(int i:numbers){
            int g=gcf(first,i);
            answer.append((first/g)+"/"+(i/g)+"\n");
        }
        System.out.print(answer);
    }
}