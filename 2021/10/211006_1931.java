//BOJ: 1931
//2021.10.05
//category: 그리디 알고리즘
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int countMax(int[][] adj,int cur){
        if(cur==adj.length) return 0;
        int next=cur;
        while(++next<adj.length) if(adj[next][0]>=adj[cur][1]) break;
        return 1+countMax(adj,next);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] adj=new int[n][2];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            adj[i][0]=Integer.parseInt(st.nextToken());
            adj[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(adj,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[1]==b[1]) return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        System.out.println(countMax(adj,0));
    }
}
