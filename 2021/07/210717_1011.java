//BOJ: 1011
//2021.07.16
//category: 기본수학
//review:
//      - x<y<2^31: stack overflow
//      - 무한루프: 도착 좌표가 아니라 이동 거리로 체크
//      - 시간초과: 완전탐색이 아니라 규칙을 활용
//                  - n이 a의 제곱 일때, 2*a-1
//                  - n이 어떤수의 제곱이 아니고, a*a 보다 크고 a*a+a 이하일때 2*a
//                  - n이 어떤수의 제곱이 아니고 a*a+a 보다 크고 (a+1)*(a+1)보다 작을 때 2*a+1

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        for(int test=0;test<t;test++){
            StringTokenizer st=new StringTokenizer(in.readLine()," ");
            int cur = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken())-cur;
            int distSqr = (int)Math.sqrt(dist);
            int answer = 0;
            if(dist==distSqr*distSqr){
                answer = 2*distSqr-1;
            }else if(dist>distSqr*(distSqr+1) ){
                answer = 2*distSqr+1;
            }else{
                answer = 2*distSqr;
            }
            out.write(Integer.toString(answer)+"\n");
        }
        out.flush();
    }
}