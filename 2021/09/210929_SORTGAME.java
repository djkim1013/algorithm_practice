//AOJ: SORTGAME
//2021.09.29
//category: 그래프의 너비 우선 탐색
//review:
//      - 현재 배열 상태를 정점으로 표현한다.

import java.util.*;
import java.io.*;

public class Main {
    HashMap<String,Integer> distance=new HashMap<String,Integer>();
    
    void preCalc(int n){
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=i;
        if(distance.containsKey(Arrays.toString(arr))) return;
        bfs(n);
    }

    void bfs(int n){
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=i;
        Queue<int[]> q=new LinkedList<int[]>();
        distance.put(Arrays.toString(arr),0);
        q.add(arr.clone());
        while(!q.isEmpty()){
            // for(int[] qarr:q){
            //     System.out.print(Arrays.toString(qarr)+" ");
            // }
            // System.out.println();
            int[] cur=q.poll();
            int curDist=distance.get(Arrays.toString(cur));
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    cur=reverse(cur,i,j);
                    if(!distance.containsKey(Arrays.toString(cur))){
                        q.add(cur.clone());
                        distance.put(Arrays.toString(cur),curDist+1);
                    }
                    cur=reverse(cur,i,j);
                }
            }
        }
    }

    int[] reverse(int[] arr,int s,int e){
        for(int i=0;s+2*i<e;i++){
            int temp=arr[s+i];
            arr[s+i]=arr[e-i];
            arr[e-i]=temp;
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        Main m=new Main();
        while(c-->0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
            int[] conv=arr.clone();
            for(int i=0;i<n;i++){
                int order=0;
                for(int j=0;j<n;j++) if(arr[i]>arr[j]) order++;
                conv[i]=order;
            }
            m.preCalc(n);
            // for(String key:m.distance.keySet()){
            //     System.out.print(key+" "+m.distance.get(key)+" ");
            // }
            // System.out.println();
            System.out.println(m.distance.get(Arrays.toString(conv)));
        }
    }
}
