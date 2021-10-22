//BOJ 11279
//2021.10.22
//category: 우선순위큐
//review:

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int last=0;
    static int[] maxHeap;

    static void add(int x){
        maxHeap[last]=x;
        int cur=last++;
        while(cur>0){
            int parent=(cur-1)/2;
            if(maxHeap[parent]>=maxHeap[cur]) return;
            int temp=maxHeap[parent];
            maxHeap[parent]=maxHeap[cur];
            maxHeap[cur]=temp;
            cur=parent;
        }
    }
    
    static int poll(){
        if(last==0) return 0;
        int ret=maxHeap[0];
        maxHeap[0]=maxHeap[--last];
        int cur=0;
        while(cur+1<last){
            int child=2*cur+1;
            if(maxHeap[child]<=maxHeap[cur]) break;
            int temp=maxHeap[child];
            maxHeap[child]=maxHeap[cur];
            maxHeap[cur]=temp;
            cur=child;
        }
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();
        maxHeap=new int[n];
        while(n-->0){
            int x=Integer.parseInt(br.readLine());
            if(x>0){
                add(x);
            }else{
                answer.append(poll()).append("\n");
            }
        }
        System.out.print(answer);
    }
}