//BOJ: 2869
//2021.07.16
//category: 기본수학
//review:
//      - while문으로 작성 시 시간초과
//      - 나눗셈으로 작성 시 시간초과
//      - 입출력을 버퍼스트림으로 변경: 오답
//      - 나눗셈의 나머지가 0보다 큰 경우 +1

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
        if((v-a)%(a-b)>0)answer++;
        out.write(Integer.toString(++answer));
        out.flush();
    }
}
