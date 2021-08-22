//AOJ: ITES
//2021.08.22
//category: 큐/스텍/데크
//review:

import java.util.*;
import java.io.*;

public class Main {
    static final long TWO_32ND=(long)Math.pow(2,32);
    static long[] A=new long[50000000];
    static long getA(int i){
        if(i==0) return A[0]=1983;
        if(A[i]>-1) return A[i];
        return A[i] = (getA(i-1) * 214013 + 2531011) % TWO_32ND;
    }
    static int getSignal(int i){
        return (int)(getA(i)%10000)+1;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int test=Integer.parseInt(br.readLine());
        Arrays.fill(A,-1);
        for(int t=0;t<test;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            int answer=0;
            int sum=0;
            Deque<Integer> deq=new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                int signal=getSignal(i);
                deq.addLast(signal);
                sum+=signal;
                while(sum>k){
                    sum-=deq.getFirst();
                    deq.removeFirst();
                }
                if(sum==k) answer++;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
	}
}