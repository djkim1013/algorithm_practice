//AOJ: GALLERY
//2021.09.25
//category: 그래프의 깊이우선탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int[][] halls;
    static int[] galleries;

    static int dfs(int cur){
        
        for(int next:halls[cur]){

        }
        return 0;
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



            
        }
        
        
    }
}
