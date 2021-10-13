//BOJ 1629
//2021.10.13
//category: 분할정복
//review:
//      - a^b = a^(b/2) * a^(b/2)

import java.util.*;
import java.io.*;

class Main{
    static int[] cache;
    static int pow(int a,int b,int c){
        int ret=cache[b];
        if(ret>-1) return ret;
        if(b==0) return ret=1;
        if(b==1) return ret=a%c;
        ret=(int)((long)pow(a,b/2,c)*pow(a,b-b/2,c)%c);
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        cache=new int[b+1];
        Arrays.fill(cache,-1);
        int c=Integer.parseInt(st.nextToken());
        System.out.println(pow(a,b,c));
    }
}