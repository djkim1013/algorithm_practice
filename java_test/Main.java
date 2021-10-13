//BOJ 1629
//2021.10.13
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    static int pow(int a,int b,int c){
        if(b==1) return a;
        return (int)((long)a*pow(a,b-1,c)%c);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        System.out.println(pow(a,b,c));
    }
}