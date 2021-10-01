//AOJ: SORTGAME
//2021.10.01
//category: 그래프의 너비 우선 탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    String bfs(char[] cList,int n, int m){
        if(String.valueOf(cList).equals("0")) return "IMPOSSIBLE";
        Queue<String> que=new LinkedList<String>();
        for(char c:cList){
            if(c=='0') continue;
            que.add(c+"");
        }
        while(!que.isEmpty()){
            String cur=que.poll();
            long curInt=Long.parseLong(cur);
            if(curInt/n>0&&curInt%n==m) return cur;
            for(char c:cList){
                que.add(cur+c);
            }
        }
        return "error";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        Main mClass=new Main();
        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char[] cList=st.nextToken().toCharArray();
            Arrays.sort(cList);
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            System.out.println(mClass.bfs(cList,n,m));
        }
    }
}
