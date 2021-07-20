//BOJ: 2231
//2021.07.20
//category: 완전탐색
//review:
//      - 오답: 답이 없는 경우 누락
//      - 오답: 답이 없는 경우 조건 오류
//      - 오답: main 내 while문을 method 내 for문으로 수정
//      - 오답: 세자리수라는 제한사항은 없다.

import java.io.*;
// import java.util.*;

public class Main {
    static int findConstructor(int n){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    if(i*101+j*11+k*2==n){
                        return i*100+j*10+k;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        out.write(findConstructor(n)+"\n");
        out.flush();
    }
}