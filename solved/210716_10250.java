//BOJ: 10250
//2021.07.16
//category: 기본수학
//review:
//      - 오답: 경계값 처리 실패
//          나눗셈에서 나머지가 0이 되는 순간 확인할 것

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
            // int w = Integer.parseInt(st.nextToken());
            new String(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int answer=0;
            answer = (n%h)*100;
            if (answer == 0) answer = h*100;
            answer += (n-1)/h+1;
            out.write(answer+"\n");
        }
        out.flush();
    }
}
