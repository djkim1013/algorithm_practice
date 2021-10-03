//AOJ: GALLERY
//2021.09.27
//category: 그래프의 깊이우선탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    static final int UNWATCHED=0, WATCHED=1, INSTALLED=2;
    static int answer;
    static ArrayList<Integer>[] halls;
    static int[] galleries;
    static boolean[] visited;

    static int dfs(int cur){
        visited[cur]=true;
        int[] children=new int[3];
        for(int next:halls[cur]){
            if(!visited[next]) children[dfs(next)]++;
        }
        if(children[UNWATCHED]>0){
            answer++;
            return galleries[cur]=INSTALLED;
        }
        if(children[INSTALLED]>0) return galleries[cur]=WATCHED;
        return galleries[cur]=UNWATCHED;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        while(c-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int g=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            halls=(ArrayList<Integer>[])new ArrayList[g];
            for(int i=0;i<g;i++) halls[i]=new ArrayList<Integer>();
            galleries=new int[g];
            visited=new boolean[g];
            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                halls[a].add(b);
                halls[b].add(a);
            }
            answer=0;
            for(int i=0;i<g;i++){
                if(!visited[i] && dfs(i)==UNWATCHED) answer++;
            }
            System.out.println(answer);
        }   
    }
}
