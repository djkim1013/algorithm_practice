//AOJ: RUNNINGMEDIAN
//2021.08.28
//category: 우선순위 큐와 힙
//review:
//      - 랜덤생성기 초기값 주의하기
//      - 직접 구현하는 것 보다 jave.util.PriorityQueue가 조금 더 빠름
//          작성도 훨씬 빠르므로 이쪽을 이용하자

import java.util.*;
import java.io.*;

class inputGen{
    int a, b;
    long A=-1;
    public inputGen(int a,int b){
        this.a=a;
        this.b=b;
    }
    int next(){
        if(A<0) return (int)(A=1983);
        return (int)(A=(A*a+b)%20090711);
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        while(c-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            inputGen value=new inputGen(a,b);
            int answer=0;
            PriorityQueue<Integer> heap1=new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> heap2=new PriorityQueue<>();
            for(int i=0;i<n;i++){
                int v=value.next();
                if(heap1.size()==heap2.size()){
                    heap1.add(v);
                }else{
                    heap2.add(v);
                }
                if(heap2.size()>0&&heap1.peek()>heap2.peek()){
                    int temp1=heap1.poll();
                    int temp2=heap2.poll();
                    heap1.add(temp2);
                    heap2.add(temp1);
                }
                answer=(answer+heap1.peek())%20090711;
            }
            System.out.println(answer);
        }
    }
}
