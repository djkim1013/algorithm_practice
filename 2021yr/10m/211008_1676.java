//BOJ: 1676
//2021.10.08
//category: 정수론 및 조합론
//review:
//      - 팩토리얼의 성질 상 n보다 작은수를 전부 포함하므로 계산 절차를 줄일 수 있다.
//      - n까지의 자연수 중 5의 배수보다 2의 배수가 항상 많다.

import java.util.*;
import java.io.*;

class Main{
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int answer=0;
        while(n>=5){
            answer+=n/=5;
        }
        System.out.println(answer);
    }
}