//BOJ: 2231
//2021.07.20
//category: 완전탐색
//review:
//      - 오답: 답이 없는 경우 누락
//      - 오답: 답이 없는 경우 조건 오류
//      - 오답: main 내 while문을 method 내 for문으로 수정
//      - 오답: 세자리수 라는 제한사항은 없다.

import java.io.*;
// import java.util.*;

public class Main {
    static int calDecomp(int n){
        int ret = n;
        while(n>0){
            ret+=n%10;
            n/=10;
        }
        return ret;
    }
    static int findConstructor(int n){
        for(int i=1;i<n;i++){
            if(calDecomp(i)==n) return i;
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