//BOJ: 2609
//2021.10.07
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int lcm(int a,int b){
        for(int n=Math.max(a,b);n<=a*b;n++){
            if(n%a==0&&n%b==0) return n;
        }
        return -1;
    }
    static int gcf(int a,int b){
        if(a>b) return gcf(b,a);
        if(a>0) return gcf(b%a,a);
        return b;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int g=gcf(a,b);
        System.out.println(g);
        System.out.println(a*b/g);
    }
}