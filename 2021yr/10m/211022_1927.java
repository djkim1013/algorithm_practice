//BOJ 1927
//2021.10.22
//category: 우선순위큐
//review:

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        StringBuilder answer=new StringBuilder();
        while(n-->0){
            int x=Integer.parseInt(br.readLine());
            if(x>0){
                minHeap.add(x);
            }else{
                answer.append(minHeap.isEmpty()?0:minHeap.poll()).append("\n");
            }
        }
        System.out.print(answer);
    }
}