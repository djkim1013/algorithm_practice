//AOJ: GALLERY
//2021.09.25
//category: 그래프의 깊이우선탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int[][] halls;
    static int[] galleries;
    static int count=0;

    static int dfs(int cur){
        if(galleries[cur]!=-1) return galleries[cur];
        for(int i=0;i<galleries.length;i++){
            if(halls[cur][i]>0&&dfs(i)==1) return galleries[cur]=0;
        }
        return galleries[cur]=1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        while(c-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int g=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            halls=new int[g][g];
            galleries=new int[g];
            Arrays.fill(galleries,-1);
            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                halls[a][b]=1;
                halls[b][a]=1;
            }
            int answer=0;
            for(int i=0;i<g;i++){
                answer+=dfs(i);
            }
            System.out.println(answer);
        }   
    }
}
