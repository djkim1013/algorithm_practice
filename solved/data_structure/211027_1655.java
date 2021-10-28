//BOJ 1655
//2021.10.27
//category: 우선순위큐
//review:

import java.io.*;
import java.util.*;

class Main{
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right=new PriorityQueue<>();
        left.add(-10001);
        right.add(10001);
        while(n-->0){
            int input=Integer.parseInt(br.readLine());
            if(input>left.peek()) right.add(input);
            else left.add(input);
            while(right.size()>left.size()){
                left.add(right.poll());
            }
            while(left.size()>right.size()+1){
                right.add(left.poll());
            }
            bw.append(left.peek().toString()).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}