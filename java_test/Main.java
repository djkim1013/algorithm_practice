//BOJ: 1931
//2021.10.05
//category: 그리디 알고리즘
//review:

import java.util.*;
import java.io.*;

public class Main {
    ArrayList<int[]> adj;
    int n;

    int countAdj(int idx){
        if(idx==n) return 1;
        int ret=countAdj(idx+1);
        int end=adj.get(idx)[1];
        int i=idx;
        while(++i<n)
            if(adj.get(i)[0]>=end){
                ret=Math.max(ret,1+countAdj(i));
                break;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        Main mn = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        mn.adj=new ArrayList<int[]>();
        mn.n = Integer.parseInt(st.nextToken());
        for(int i=0;i<mn.n;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            mn.adj.add(new int[]{start,end});
        }
        Collections.sort(mn.adj,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        System.out.println(mn.countAdj(0));
    }
}
