//BOJ: 1011
//2021.07.16
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        for(int test=0;test<t;test++){
            StringTokenizer st=new StringTokenizer(in.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int answser = 0;
            out.write(Integer.toString(answer));
        }
        out.flush();
    }
}