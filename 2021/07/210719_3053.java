//BOJ: 3053
//2021.07.19
//category: 기본수학
//review:

import java.io.*;
// import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int r = Integer.parseInt(in.readLine());
        double ucle = Math.PI*r*r;
        double taxi = 2d*r*r;
        out.write(ucle+"\n"+taxi);
        out.flush();
    }
}