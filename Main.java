//BOJ: 10250
//2021.07.16
//category: 기본수학
//review:
//      - 오답: w를 고려하지 않았음

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        for(int test=0;test<t;test++){
            String input = in.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int answer=0;
            answer = (n%h)*100;
            answer += n/h+1;

            out.write(answer+"\n");
        }
        out.flush();
    }
}
