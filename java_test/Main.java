//BOJ: 5086
//2021.10.06
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

public class Main {
    static String judge(int a,int b){
        if(a>b){
            if(a%b==0) return "multilple";
        }else if(b%a==0) return "factor";
        return "neither";
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        while(true){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a==0&&b==0) break;
            System.out.println(judge(a,b));
        }
    }
}
