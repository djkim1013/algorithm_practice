//BOJ: 1978
//2021.07.16
//category: 기본수학
//review:
//      - 최적화: 대상의 제곱근보다 큰 약수는 의미가 없으므로 세지 않아도 된다.
//      - 오답: 1의 경우 처리를 빼먹음

import java.io.*;
import java.util.*;

public class Main {
    static boolean judgePrime(int number){
        if(number==1)return false;
        for(int i=2;i<=(int)Math.sqrt(number);i++){
            if(number%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int answer = 0;
        for(int i=0;i<n;i++){
            int number=Integer.parseInt(st.nextToken());
            if(judgePrime(number))answer++;
        }
        out.write(Integer.toString(answer));
        out.flush();
    }
}