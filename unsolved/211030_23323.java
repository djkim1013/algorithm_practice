//BOJ 23323 홍대 경진대회 D
//2021.10.30
//category: 그리디 알고리즘
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            long n=Long.parseLong(st.nextToken());
            long m=Long.parseLong(st.nextToken());
            while((n/=2)>0) m++;
            answer.append(++m).append("\n");
        }
        System.out.print(answer);
    }
}