//BOJ: 1427
//2021.07.21
//category: 정렬
//review:

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str = in.readLine().toCharArray();
        Arrays.sort(str);
        for(int i=str.length-1;i>=0;i--){
            out.write(str[i]);
        }
        out.flush();
    }
}