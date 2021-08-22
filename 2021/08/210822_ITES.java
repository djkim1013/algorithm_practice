//AOJ: ITES
//2021.08.22
//category: 큐/스텍/데크
//review:
//      - "온라인알고리즘"

import java.util.*;
import java.io.*;

public class Main {
    static final long TWO_32ND=(long)Math.pow(2,32);
    static long A = -1;
    static long nextA(){
        if(A<0) return A=1983;
        return A = (A * 214013 + 2531011) % TWO_32ND;
    }
    static int getSignal(){
        return (int)(nextA()%10000)+1;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int test=Integer.parseInt(br.readLine());
        for(int t=0;t<test;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            int answer=0;
            int sum=0;
            Queue<Integer> que=new LinkedList<Integer>();
            A=-1;
            for(int i=0;i<n;i++){
                int signal=getSignal();
                // if(i<5)System.out.println(signal);
                que.add(signal);
                sum+=signal;
                while(sum>k){
                    sum-=que.poll();
                }
                if(sum==k) answer++;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
	}
}