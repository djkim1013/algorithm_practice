//BOJ 1629
//2021.10.13
//category: 분할정복
//review:
//      - a^b = a^(b/2) * a^(b/2)
//      - 메모리 제한에 주의

import java.util.*;
import java.io.*;

class Main{
    static int a,b,c;
    static int pow(int idx){
        if(idx==0) return 1;
        if(idx==1) return a%c;
        int ret=pow(idx/2);
        ret=(int)((int)ret*ret%c);
        if(idx%2>0) ret=(int)((int)ret*a%c);
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        System.out.println(pow(b));
    }
}