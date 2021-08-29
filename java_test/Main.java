//AOJ: WORDCHAIN
//2021.08.29
//category: 깊이우선탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    static final int M=26;
    static ArrayList<String>[][] graph;
    static int[][] adj;
    static int[] in,out;
    static int n;
    static ArrayList<Integer> circuit;
    static void makeGraph(String[] words){
        graph=(ArrayList<String>[][])new ArrayList[M][M];
        adj=new int[M][M];
        in=new int[M];
        out=new int[M];
        for(int i=0;i<n;i++){
            int a=words[i].charAt(0)-'a';
            int b=words[i].charAt(words[i].length()-1)-'a';
            if(graph[a][b]==null)
                graph[a][b]=new ArrayList<String>();
            graph[a][b].add(words[i]);
            adj[a][b]++;
            out[a]++;
            in[b]++;
        }
    }
    static void getEulerCircuit(int cur){
        for(int next=0;next<n;next++){
            while(adj[cur][next]>0){
                adj[cur][next]--;
                getEulerCircuit(next);
            }
        }
        circuit.add(cur);
    }
    static void getEulerCircuitOrTrail(){
        for(int i=0;i<26;i++){
            if(out[i]==in[i]+1){
                getEulerCircuit(i);
                return;
            }
        }
        for(int i=0;i<26;i++){
            if(out[i]>0){
                getEulerCircuit(i);
                return;
            }
        }
    }
    static boolean checkEuler(){
        int plus1=0, minus1=0;
        for(int i=0;i<26;i++){
            int del=out[i]-in[i];
            if(del==1) plus1++;
            if(del==-1) minus1++;
            if(del!=0) return false;
        }
        return (plus1==1&&minus1==1)||(plus1==0&&minus1==0);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        while(C-->0){
            n = Integer.parseInt(br.readLine());
            String[] words=new String[n];
            for(int i=0;i<n;i++){
                words[i]=br.readLine();
            }
            makeGraph(words);
            if(!checkEuler())
                System.out.println("IMPOSSIBLE");
            else{
                getEulerCircuitOrTrail();
                if(circuit.size()==0)
                    System.out.println("IMPOSSIBLE");
                else{
                    StringBuilder answer=new StringBuilder();
                    for(int i=n-1;i>0;i++){
                        int a=circuit.get(i-1), b=circuit.get(i);
                        answer.insert(0,graph[a][b].get(graph[a][b].size()-1));
                        graph[a][b].remove(graph[a][b].size()-1);
                    }
                    System.out.println(answer);;
                }
            }
        }
    }
}
