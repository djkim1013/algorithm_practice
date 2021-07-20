//BOJ: 2798
//2021.07.20
//category: 재귀함수 구현
//review:
//      - 세장을 고르기 전 합의 크기는 마지막 총 합과 상관이 없다.

import java.io.*;
import java.util.*;

public class Main {
    static int[] cards;
    static int m, n;
    static int answer=0;_
    static void findBlackJack(int idx,int used,int sum){
        if(used==3){
            if(sum>m)return;
            answer=Math.max(answer,sum);
            return;
        }
        if(idx==n)return;
        findBlackJack(idx+1,used+1,sum+cards[idx]);
        findBlackJack(idx+1,used,sum);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        cards = new int[n];
        for(int i=0;i<n;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        findBlackJack(0,0,0);
        out.write(answer+"\n");
        out.flush();
    }
}