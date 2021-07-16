//BOJ: 1011
//2021.07.16
//category: 기본수학
//review:
//      - x<y<2^31: stack overflow
//      - k stack overflow

import java.io.*;
import java.util.*;

public class Main {
    static int goal;
    static int calDays(int cur,int k){
        if(cur>=goal){
            if(cur==goal&&k==1)return 0;
            return 0xfff0000;
        }
        int ret=0xfff0000;
        for(int i=k-1;i<=k+1;i++){
            if(i<=0||i>=Integer.MAX_VALUE-1)continue;
            if(cur>=Integer.MAX_VALUE-i)continue;
            ret=Math.min(calDays(cur+i,i),ret);
        }
        return ++ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(((1<<31)-1)+" "+Integer.MAX_VALUE);
        int t = Integer.parseInt(in.readLine());
        for(int test=0;test<t;test++){
            StringTokenizer st=new StringTokenizer(in.readLine()," ");
            int cur = Integer.parseInt(st.nextToken());
            goal = Integer.parseInt(st.nextToken());
            int answer = calDays(cur,0);
            out.write(Integer.toString(answer)+"\n");
        }
        out.flush();
    }
}