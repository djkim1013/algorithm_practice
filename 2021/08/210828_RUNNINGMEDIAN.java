//AOJ: RUNNINGMEDIAN
//2021.08.28
//category: 우선순위 큐와 힙
//review:
//      - 랜덤생성기 초기값 주의하기

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

class MaxHeap{
    ArrayList<Integer> heap=new ArrayList<Integer>();
    void swapNode(int a,int b){
        int temp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,temp);
    }
    void push(int value){
        heap.add(value);
        int idx=heap.size()-1;
        while(idx>0&&heap.get((idx-1)/2)<value){
            swapNode((idx-1)/2,idx);
            idx=(idx-1)/2;
        }
    }
    int poll(){
        int ret = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int cur=0;
        while(true){
            int left=cur*2+1, right=cur*2+2;
            //마지막 리프 도달
            if(left>=heap.size()) break;
            int next=cur;
            //왼쪽 노드로 내려갈 수 있음
            if(heap.get(next)<heap.get(left)) next=left;
            //오른쪽 노드로 내려갈 수 있음
            if(right<heap.size()&&heap.get(next)<heap.get(right)) next=right;
            //양쪽 노드 모두 내려갈 수 없음
            if(next==cur) break;
            swapNode(cur,next);
            cur=next;
        }
        return ret;
    }
    int get(int idx){
        return heap.get(idx);
    }
    int size(){
        return heap.size();
    }
}

class MinHeap{
    ArrayList<Integer> heap=new ArrayList<Integer>();
    void swapNode(int a,int b){
        int temp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,temp);
    }
    void push(int value){
        heap.add(value);
        int idx=heap.size()-1;
        while(idx>0&&heap.get((idx-1)/2)>value){
            swapNode((idx-1)/2,idx);
            idx=(idx-1)/2;
        }
    }
    int poll(){
        int ret = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int cur=0;
        while(true){
            int left=cur*2+1, right=cur*2+2;
            //마지막 리프 도달
            if(left>=heap.size()) break;
            int next=cur;
            //왼쪽 노드로 내려갈 수 있음
            if(heap.get(next)>heap.get(left)) next=left;
            //오른쪽 노드로 내려갈 수 있음
            if(right<heap.size()&&heap.get(next)>heap.get(right)) next=right;
            //양쪽 노드 모두 내여갈 수 없음
            if(next==cur) break;
            swapNode(cur,next);
            cur=next;
        }
        return ret;
    }
    int get(int idx){
        return heap.get(idx);
    }
    int size(){
        return heap.size();
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
            MaxHeap heap1=new MaxHeap();
            MinHeap heap2=new MinHeap();
            for(int i=0;i<n;i++){
                int v=value.next();
                if(heap1.size()==heap2.size()){
                    heap1.push(v);
                }else{
                    heap2.push(v);
                }
                if(heap2.size()>0&&heap1.get(0)>heap2.get(0)){
                    int temp1=heap1.poll();
                    int temp2=heap2.poll();
                    heap1.push(temp2);
                    heap2.push(temp1);
                }
                answer=(answer+heap1.get(0))%20090711;
            }
            System.out.println(answer);
        }
    }
}
