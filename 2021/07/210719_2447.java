//BOJ: 2447
//2021.07.19
//category: 재귀함수 구현
//review:

import java.io.*;
// import java.util.*;

public class Main {
    static char starPattern(int i,int j,int div){
        if(div==3){
            if(i==j&&i==1){
                return ' ';
            }
            return '*';
        }
        if(i>=div/3&&i<2*div/3&&j>=div/3&&j<2*div/3){
            return ' ';
        }
        return starPattern(i%(div/3),j%(div/3),div/3);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        for(int i=0;i<n;i++){
            StringBuilder answer = new StringBuilder();
            for(int j=0;j<n;j++){
                answer.append(starPattern(i,j,n));
            }
            out.write(answer.toString());
            out.newLine();
        }
        out.flush();
    }
}