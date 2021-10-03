//AOJ: MEETINGROOM
//2021.09.28
//category: 그래프의 깊이우선탐색
//review:
//      - 2-SAT 문제:참/거짓의 두쌍으로 이루어진 문제
//      - 함의그래프: P=>Q 의 => 기호를 간선으로 표현, 각 조건에 대해 P, Pc를 두 정점으로 둔다
//      - 타잔 알고리즘: 함의그래프를 강결합컴포넌트(scc) 별로 분리 -> 한 요소가 두 scc에 속하면 불가능

import java.util.*;
import java.io.*;

public class Main {
    ArrayList<Integer>[] adj;
    Stack<Integer> stk;
    int sccCounter, vertexCounter;
    int[] sccId,discovered;

    int[] solve2SAT(){
        int n=adj.length;
        int[] answer;
        int[] label=tarjanSCC();            
        for(int i=0;i<n;i+=2){
            if(label[i]==label[i+1]){
                return answer=null;
            }
        }
        answer=new int[n];
        Arrays.fill(answer,-1);
        ArrayList<int[]> order=new ArrayList<int[]>();
        for(int i=0;i<n;i++){
            order.add(new int[]{label[i],i});
        }
        Collections.sort(order,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[0]-a[0];
            }
        });
        for(int i=0;i<n;i++){
            int vertex=order.get(i)[1];
            int team=vertex/2;
            boolean isTrue=vertex%2==0;
            if(answer[team]!=-1) continue;
            answer[team]=isTrue?0:1;
        }
        return answer;
    }

    int scc(int cur){
        int ret=discovered[cur]=vertexCounter++;
        stk.push(cur);
        for(int i=0;i<adj[cur].size();i++){
            int next=adj[cur].get(i);
            if(discovered[next]==-1){
                ret=Math.min(ret,scc(next));
            }else if(sccId[next]==-1){
                ret=Math.min(ret,discovered[next]);
            }
        }
        if(ret==discovered[cur]){
            while(true){
                int t=stk.peek();
                stk.pop();
                sccId[t]=sccCounter;
                if(t==cur) break;
            }
            sccCounter++;
        }
        return ret;
    }

    int[] tarjanSCC(){
        sccId=new int[adj.length];
        discovered=new int[adj.length];
        Arrays.fill(sccId,-1);
        Arrays.fill(discovered,-1);
        sccCounter=vertexCounter=0;
        for(int i=0;i<adj.length;i++) if(discovered[i]==-1) scc(i);
        return sccId;
    }

    boolean disjoint(int[] a, int[] b){
        return a[1]<=b[0]||a[0]>=b[1];
    }

    void makeGraph(ArrayList<int[]> meetings){
        adj=(ArrayList<Integer>[])new ArrayList[meetings.size()*2];
        int size=meetings.size();
        for(ArrayList<Integer> arr:adj) arr=new ArrayList<Integer>();
        for(int i=0;i<size;i+=2){
            int j=i+1;
            adj[i*2+1].add(j*2);
            adj[j*2+1].add(i*2);
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<i;j++){
                if(!disjoint(meetings.get(i),meetings.get(j))){
                    adj[i*2].add(j*2+1);
                    adj[j*2].add(i*2+1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        Main m=new Main();
        while(c-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<int[]> meetings=new ArrayList<int[]>();
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int s=Integer.parseInt(st.nextToken());
                int e=Integer.parseInt(st.nextToken());
                meetings.add(new int[]{s,e});
                s=Integer.parseInt(st.nextToken());
                e=Integer.parseInt(st.nextToken());
                meetings.add(new int[]{s,e});
            }
            m.makeGraph(meetings);
            int[] answer=m.solve2SAT();
            if(answer==null){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println("POSSIBLE");
                for(int i=0;i<n;i++){
                    int[] meeting=meetings.get(2*i+answer[i]);
                    System.out.println(meeting[0]+" "+meeting[1]);
                }
            }
        }
    }
}
