//BOJ 11444
//2021.10.14
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        long n=Long.parseLong((new BufferedReader(new InputStreamReader(System.in))).readLine());
        final int MOD=1000000007;
        int answer=0;
        LinkedList<Integer> que=new LinkedList<Integer>();
        que.add(0);
        que.add(1);
        for(long i=2;i<=n;i++){
            answer=que.pollFirst()+que.peek();
            answer%=MOD;
            que.add(answer);
        }
        System.out.print(answer);
    }
}