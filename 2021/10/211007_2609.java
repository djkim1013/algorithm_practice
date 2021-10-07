//BOJ: 2609
//2021.10.07
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int gcf(int a,int b){
        for(int n=Math.min(a,b);n>=1;n--){
            if(a%n==0&&b%n==0) return n;
        }
        return -1;
    }

    static int lcm(int a,int b){
        return b*a/gcf(a,b);
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        StringBuilder answer=new StringBuilder();
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            answer.append(lcm(a,b)+"\n");
        }
        System.out.print(answer);
    }
}