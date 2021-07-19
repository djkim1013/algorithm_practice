//BOJ: 4153
//2021.07.19
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

public class Main {
    
    static String judgeTriangle(int a,int b,int c){
        if(a*a+b*b==c*c)
            return "right";
        if(a*a+c*c==b*b)
            return "right";
        if(b*b+c*c==a*a)
            return "right";
        return "wrong";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=0,b=0,c=0;
        while(true){
            StringTokenizer st=new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a+b+c==0)break;
            out.write(judgeTriangle(a,b,c));
            out.newLine();
        }
        out.flush();
    }
}