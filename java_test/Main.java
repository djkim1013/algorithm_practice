//BOJ 2110
//2021.10.21
//category: 이분탐색
//review:

//brute force
import java.io.*;
import java.util.*;

class Main{
    static int[] dist;
    static int dfs(int idx,int c,boolean[] cur){
        if(c==0){
            return minDist(cur);
        }
        if(idx==cur.length){
            return 0;
        }
        int ret=dfs(idx+1,c,cur);
        cur[idx]=true;
        ret=Math.max(ret,dfs(idx+1,c-1,cur));
        cur[idx]=false;
        return ret;
    }
    
    static int minDist(boolean[] installed){
        int min=Integer.MAX_VALUE;
        int cur=0;
        int d=installed[0]?dist[0]:Integer.MAX_VALUE;
        while(++cur<installed.length){
            if(installed[cur]){
                min=Math.min(min,d);
                d=dist[cur];
            }else{
                d+=dist[cur];
            }
        }
        return min;
    }
    
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] house=new int[n];
        for(int i=0;i<n;i++){
            house[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        dist=new int[n];
        for(int i=0;i+1<n;i++){
            dist[i]=house[i+1]-house[i];
        }
        System.out.println(dfs(0,c,new boolean[n]));
    }
}