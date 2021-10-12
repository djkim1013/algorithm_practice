//BOJ 11866
//2021.10.12
//category: 큐, 덱
//review:
//      - 우선순위 큐 구현

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<int[]> que;
        int n,m;
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            
            st=new StringTokenizer(br.readLine());
            que=new ArrayList<int[]>();
            int[] prior=new int[n];
            
            for(int i=0;i<n;i++){
                int p=Integer.parseInt(st.nextToken());
                que.add(new int[]{i,p});
                prior[i]=p;
            }
            Arrays.sort(prior);
            int cur=0, len=n;
            while(len-->0){
                int p=prior[len];
                while(que.get(cur)[1]<p) cur=++cur%(len+1);
                if(que.get(cur)[0]==m){
                    System.out.println((n-len));
                }
                que.remove(cur);
                cur=Math.max(cur,len-1);
                
            }
        }
    }
}