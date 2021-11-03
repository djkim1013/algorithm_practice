//BOJ 23296 APC - E
//2021.10.30
//category: 그리디, 깊이우선탐색
//review:

import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[] floor;
    static int[][] cache;
    static int minControl(int cur,int complete,boolean[] visited){
        if(complete==n) return 0;
        int ret=cache[cur][complete];
        if(ret!=-1) return ret;
        ret=2*n;
        visited[cur]=true;
        if(!visited[cur]){
            ret=1+minControl(floor[cur],complete+1,visited);
        }else{
            for(int i=1;i<=n;i++){
                if(!visited[i])
                    ret=Math.min(ret,1+minControl(i,complete,visited));
            }
        }
        visited[cur]=false;
        return cache[cur][complete]=ret;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        floor=new int[n+1];
        cache=new int[n+1][n];
        for(int i=1;i<=n;i++) floor[i]=Integer.parseInt(st.nextToken());
        System.out.println(minControl(1,0,new boolean[n+1]));
    }
}