//BOJ: 7568
//2021.07.20
//category: 완전탐색
//review:

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static String[] board;

    static char toggle(char before){
        if(before=='W') return 'B';
        return 'W';
    }
    
    static int modBoard(int iFirst,int jFirst){
        int ret=0;
        char now='W';
        for(int i=iFirst;i<iFirst+8;i++){
            for(int j=jFirst;j<jFirst+8;j++){
                if(board[i].charAt(j)!=now) ret++;
                now=toggle(now);
            }
            now=toggle(now);
        }
        return Math.min(ret,64-ret);
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board = new String[n];
        for(int i=0;i<n;i++) board[i]=in.readLine();
        int answer = 0xffff;
        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                answer=Math.min(answer,modBoard(i,j));
            }
        }
        out.write(answer+"");
        out.flush();
    }
}