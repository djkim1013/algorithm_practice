//BOJ: 9184
//2021.07.29
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[][][] cache=new int[21][21][21];
    static int w(int a,int b,int c){
        if(a<=0||b<=0||c<=0) return 1;
        if(a>20||b>20||c>20) return w(20,20,20);
        int ret = cache[a][b][c];
        if(ret>-1) return ret;
        if(a<b&&b<c){
            ret = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
            cache[a][b][c] = ret;
            return ret;
        }
        ret = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        cache[a][b][c] = ret;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                Arrays.fill(cache[i][j],-1);
            }
        }
        String input = "";
        while(!"-1 -1 -1".equals(input = in.readLine())){
            StringTokenizer st = new StringTokenizer(input);
            int[] numbers = new int[3];
            for(int i=0;i<3;i++) numbers[i] = Integer.parseInt(st.nextToken());
            out.write("w("+numbers[0]+", "+numbers[1]+", "+numbers[2]+") = ");
            out.write(w(numbers[0],numbers[1],numbers[2])+"\n");
        }
        out.flush();
    }
}