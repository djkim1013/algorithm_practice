//BOJ: 1037
//2021.10.07
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int min, max;
        min=max=Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            int input=Integer.parseInt(st.nextToken());
            if(input<min) min=input;
            if(input>max) max=input;
        }
        System.out.println(min*max);
    }
}