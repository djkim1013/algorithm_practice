//BOJ: 2869
//2021.07.15
//category: 기본수학
//review:
//      - while문으로 작성 시 시간초과
//      - 나눗셈으로 작성 시 시간초과

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int answer = v-a;
        if(answer<=0){
            System.out.println(1);
            return;
        } 
        answer /= a-b;
        out.write(Integer.toString(++answer));
        out.flush();
    }
}
