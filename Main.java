//BOJ: 1011
//2021.07.16
//category: 기본수학
//review:
//      - x<y<2^31: stack overflow
//      - 무한루프: 도착 좌표가 아니라 이동 거리로 체크
//      - 시간초과: 완전탐색 최적화

import java.io.*;
import java.util.*;

public class Main {
    static int calDays(int dist,int k){
        if(dist<=0){
            if(dist==0&&k==1)return 0;
            return 0xfff0000;
        }
        int ret=0;
        for(int i=k-1;i<=k+1;i++){
            if(i<=0)continue;
            if(ret==0){
                ret=calDays(dist-i,i);
                continue;
            } 
            ret=Math.min(calDays(dist-i,i),ret);
        }
        return ret<Integer.MAX_VALUE?++ret:ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        for(int test=0;test<t;test++){
            StringTokenizer st=new StringTokenizer(in.readLine()," ");
            int cur = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken())-cur;
            int answer = calDays(dist,0);
            out.write(Integer.toString(answer)+"\n");
        }
        out.flush();
    }
}