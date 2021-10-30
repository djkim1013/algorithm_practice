import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int answer=0;
        int[][] edges=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(edges[i],-1);
        while(m-->0){
            st=new StringTokenizer(br.readLine());
            int value=--k==0?1:0;
            int i=Integer.parseInt(st.nextToken());
            int j=Integer.parseInt(st.nextToken());
            edges[i][j]=value;
            edges[i][j]=value;
        }
        for(int i=0;i+1<n;i++){
            for(int j=i+1;j<n;j++){
                if(edges[i][j]!=-1){
                    answer+=edges[i][j];
                    continue;
                }
                Queue<Integer> que=new LinkedList<>();
                que.add(i);
                int d=n;
                while(!que.isEmpty()){
                    int cur=que.poll();
                    if(cur==j) d=Math.min() 
                }
            }
        }
        
    }
}