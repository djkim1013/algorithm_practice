//BOJ 2164
//2021.10.12
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Queue<Integer> que=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            que.add(i);
        }
        while(que.size()>1){
            que.remove();
            int temp=que.poll();
            que.add(temp);
        }
        System.out.println(que.peek());
    }
}