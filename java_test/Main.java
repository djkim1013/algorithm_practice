//BOJ 11279
//2021.10.22
//category: 우선순위큐
//review:

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main{
    
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        while(n-->0){
            int x=Integer.parseInt(br.readLine());
            if(x>0){
                maxHeap.add(x);
            }else{
                answer.append(maxHeap.isEmpty()?0:maxHeap.poll()).append("\n");
            }
        }
        System.out.print(answer);
    }
    
}