//BOJ: 1037
//2021.10.06
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int answer=1;
        StringTokenizer st=new StringTokenizer(br.readLine());
        while(n-->0){
            answer*=Integer.parseInt(st.nextToken());
        }
        System.out.println(answer);
    }
}
