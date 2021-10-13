//BOJ 1021
//2021.10.13
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] target=new int[m];
        for(int i=0;i<m;i++){
            target[i]=Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> deq=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            deq.add(i);
        }
        int answer=0;
        for(int i=0;i<m;i++){
            int move=deq.indexOf(target[i]);
            if(move>n/2){
                answer+=move=n-move;
                while(move-->0){
                    deq.addFirst(deq.pollLast());
                }
            }else{
                answer+=move;
                while(move-->0){
                    deq.addLast(deq.pollFirst());
                }
            }
            deq.removeFirst();
            n--;
        }
        System.out.println(answer);
    }
}