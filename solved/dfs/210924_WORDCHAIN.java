//AOJ: WORDCHAIN
//2021.09.24
//category: 그래프의 깊이우선탐색
//review:
//      - 출력문 판정에 의한 오답...

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<String>[][] graph;
    static int[][] adj;
    static int[] in,out;
    static int n;
    static ArrayList<Integer> circuit;

    static void getEulerCircuit(int cur){
        for(int next=0;next<26;next++){
            while(adj[cur][next]>0){
                adj[cur][next]--;
                getEulerCircuit(next);
            }
        }
        circuit.add(cur);
    }
    static void getEulerCircuitOrTrail(){
        circuit = new ArrayList<Integer>();
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
            else if(del==-1) minus1++;
            else if(del!=0) return false;
        }
        return (plus1==minus1)&&(plus1<=1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while(C-->0){
            n = Integer.parseInt(br.readLine());
            String[] words=new String[n];
            for(int i=0;i<n;i++) words[i]=br.readLine();
            graph=(ArrayList<String>[][])new ArrayList[26][26];
            adj=new int[26][26];
            in=new int[26];
            out=new int[26];
            for(String str:words){
                int a=str.charAt(0)-'a';
                int b=str.charAt(str.length()-1)-'a';
                if(graph[a][b]==null) graph[a][b]=new ArrayList<String>();
                graph[a][b].add(str);
                adj[a][b]++;
                out[a]++;
                in[b]++;
            }
            if(!checkEuler()){
                //bw.append("IMPOSSIBLE\n");
                System.out.println("IMPOSSIBLE");
                continue;
            }
            getEulerCircuitOrTrail();
            if(circuit.size()!=n+1){
                //bw.append("IMPOSSIBLE\n");
                System.out.println("IMPOSSIBLE");
                continue;
            }
            StringBuilder answer=new StringBuilder();
            for(int i=circuit.size()-1;i>0;i--){
                int a=circuit.get(i), b=circuit.get(i-1);
                answer.append(graph[a][b].get(graph[a][b].size()-1));
                answer.append(" ");
                graph[a][b].remove(graph[a][b].size()-1);
            }
            bw.append(answer+"\n");
            bw.flush();
            // System.out.println(answer);
        }
        //bw.flush();
        br.close();
        bw.close();
    }
}
