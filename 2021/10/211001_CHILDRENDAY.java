//AOJ: CHILDRENDAY
//2021.10.01
//category: 그래프의 너비 우선 탐색
//review:
//      - 만들어진 결과값이 아니라 자릿수로 정점을 만든다.
//      - 결과값에 직접 연산하지 않아도 나머지만 가지고 연산해도 결과는 같다.

import java.util.*;
import java.io.*;

public class Main {
    int getMod(int cur,int next,int mod){
        int ret=cur*10+next;
        if(ret>=mod) return mod+ret%mod;
        return ret%mod;
    }

    String bfs(char[] cList,int n, int m){
        Queue<Integer> que=new LinkedList<Integer>();
        int[] parent=new int[2*n], choice=new int[2*n];
        Arrays.fill(parent,-1);
        Arrays.fill(choice,-1);
        parent[0]=0;
        que.add(0);
        while(!que.isEmpty()){
            int cur=que.poll();
            for(char c:cList){
                int next=getMod(cur,c-'0',n);
                if(parent[next]==-1){
                    parent[next]=cur;
                    choice[next]=c-'0';
                    que.add(next);
                }
            }
        }
        if(parent[n+m]==-1) return "IMPOSSIBLE";
        String ret="";
        int cur=n+m;
        while(parent[cur]!=cur){
            ret=choice[cur]+ret;
            cur=parent[cur];
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        Main mClass=new Main();
        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char[] cList=st.nextToken().toCharArray();
            Arrays.sort(cList);
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            System.out.println(mClass.bfs(cList,n,m));
        }
    }
}
