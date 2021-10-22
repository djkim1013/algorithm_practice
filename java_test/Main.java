//BOJ 11279
//2021.10.22
//category: 우선순위큐
//review:

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;

class Main{
    static int last=0;
    static int[] maxHeap;

    static void sort(){
        int cur=last;
        while(cur>0){
            int next=(cur-1)/2;
            if(maxHeap[next]>=maxHeap[cur]) return;
            int temp=maxHeap[next];
            maxHeap[next]=maxHeap[cur];
            maxHeap[cur]=temp;
            cur=next;
        }
    }

    static void add(int x){
        maxHeap[last]=x;
        sort();
        last++;
    }
    
    static int poll(){
        if(last==0) return 0;
        int ret=maxHeap[0];
        maxHeap[0]=maxHeap[--last];
        sort();
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
            //System.out.println(last+" "+Arrays.toString(maxHeap));
        }
        System.out.print(answer);
    }
}