//baekjoon : 15552
//21.06.24
//문제 분류: 구현
//해결 분석: 대용량 입출력에 대해 buffer stream 활용

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	bw.append(a+b+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
