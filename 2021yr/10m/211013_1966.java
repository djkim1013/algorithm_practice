//BOJ 1966
//2021.10.13
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<int[]> que;
        int[] prior;
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            que=new LinkedList<int[]>();
            prior=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                prior[i]=Integer.parseInt(st.nextToken());
                que.add(new int[]{i,prior[i]});
            }
            Arrays.sort(prior);
            for(int i=n-1;i>=0;i--){
                int max=prior[i];
                while(que.peek()[1]<max){
                    que.add(que.poll());
                }
                if(que.peek()[0]==m){
                    System.out.println(n-i);
                    break;
                }
                que.remove();
            }
        }
    }
}