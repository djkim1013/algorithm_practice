//AOJ: DICTIONARY
//2021.08.29
//category: 깊이우선탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    static final int M=26;
    static String[] input;
    static boolean[][] adj;
    static boolean[] seen;
    static ArrayList<Integer> answer;
    static int n;

    static void makeGraph(){
        adj=new boolean[M][M];
        for(int i=1;i<n;i++){
            String a=input[i-1], b=input[i];
            int len=Math.min(a.length(),b.length());
            for(int j=0;j<len;j++){
                if(a.charAt(j)!=b.charAt(j)){
                    int front=a.charAt(j)-'a';
                    int back=b.charAt(j)-'a';
                    adj[front][back]=true;
                    break;
                }
            }
        }
    }
    static void dfs(int cur){      
        seen[cur]=true;
        for(int next=0;next<M;next++){
            if(!seen[next]&&adj[cur][next]) dfs(next);
        }
        answer.add(cur);
    }
    static void topologicalSort(){
        seen=new boolean[M];
        answer=new ArrayList<Integer>();
        for(int i=0;i<M;i++){
            if(!seen[i]) dfs(i);
        }
        Collections.reverse(answer);
        for(int i=0;i<M;i++){
            for(int j=i+1;j<M;j++){
                if(adj[answer.get(j)][answer.get(i)]){
                    answer.clear();
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        while(C-->0){
            n = Integer.parseInt(br.readLine());
            input = new String[n];
            for(int i=0;i<n;i++){
                input[i]=br.readLine();
            }
            makeGraph();
            topologicalSort();
            if(answer.size()<1){
                System.out.println("INVALID HYPOTHESIS");
            }else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<answer.size();i++){
                    output.append((char)(answer.get(i)+'a'));
                }
                System.out.println(output);
            }
        }
    }
}
