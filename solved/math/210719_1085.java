//BOJ: 1085
//2021.07.19
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int answer = 1000;
        answer = Math.min(answer,x);
        answer = Math.min(answer,y);
        answer = Math.min(answer,w-x);
        answer = Math.min(answer,h-y);
        out.write(answer+"\n");
        out.flush();
    }
}