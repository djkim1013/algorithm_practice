//BOJ: 15651
//2021.07.23
//category: backtracking
//review:
//      - 시간초과: 재귀함수에서 중복된 결과를 계산하지 않도록 주의

// import java.util.*;
import java.io.*;

public class Main{
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static void list(String output)throws IOException{
        if(output.length()==m){
            for(int i=0;i<m;i++){
                out.write(output.charAt(i)+" ");
            }
            out.newLine();
            return;
        }
        for(int i=1;i<=n;i++){
            list(output+i);
        }
    }
    public static void main(String[] args)throws IOException{
        n = System.in.read()-'0';
        System.in.read();
        m = System.in.read()-'0';
        list("");
        out.flush();
    }
}