//AOJ: RUNNINGMEDIAN
//2021.08.28
//category: 우선순위 큐와 힙
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int a, b;
    static long A;
    static int inputGen(){
        A=(A*a+b)%20090711;
        return (int)A;
    }
    static ArrayList<Integer> heap1, heap2;
    static void swapNode(ArrayList<Integer> heap,int a,int b){
        int temp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,temp);
    }
    static void pushMaxHeap(ArrayList<Integer> heap,int value){
        heap.add(value);
        int idx=heap.size()-1;
        while(idx>0&&heap.get((idx-1)/2)<value){
            swapNode(heap,(idx-1)/2,idx);
            idx=(idx-1)/2;
        }
    }
    static void pushMinHeap(ArrayList<Integer> heap,int value){
        heap.add(value);
        int idx=heap.size()-1;
        while(idx>0&&heap.get((idx-1)/2)>value){
            swapNode(heap,(idx-1)/2,idx);
            idx=(idx-1)/2;
        }
    }
    static int pollMaxHeap(ArrayList<Integer> heap){
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
            //양쪽 노드 모두 내여갈 수 없음
            if(next==cur) break;
            swapNode(heap,cur,next);
            cur=next;
        }
        return ret;
    }
    static int pollMinHeap(ArrayList<Integer> heap){
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
            swapNode(heap,cur,next);
            cur=next;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        while(c-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            A=1983;
            int answer=0;
            heap1=new ArrayList<Integer>();
            heap2=new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                int a=inputGen();
                if(heap1.size()==heap2.size()){
                    pushMaxHeap(heap1,a);
                }else{
                    pushMinHeap(heap2,a);
                }
                if(heap2.size()>0&&heap1.get(0)>heap2.get(0)){
                    int temp1=pollMaxHeap(heap1);
                    int temp2=pollMinHeap(heap2);
                    pushMinHeap(heap2,temp1);
                    pushMaxHeap(heap1,temp2);
                }
                answer=(answer+heap1.get(0))%20090711;

            }
            System.out.println(answer);
        }
    }
}
