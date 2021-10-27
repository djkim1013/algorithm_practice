//BOJ 11286
//2021.10.27
//category: 우선순위큐
//review:

import java.io.*;
import java.util.*;

class Main{
    static class Number implements Comparable<Number>{
        int value;
        @Override
        public int compareTo(Number that){
            int a=this.value>0?this.value:-this.value;
            int b=that.value>0?that.value:-that.value;
            if(a==b) return this.value-that.value;
            return a-b;
        }
    }
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Number> priorQ=new PriorityQueue<>();
        while(n-->0){
            int input=Integer.parseInt(br.readLine());
            if(input==0){
                bw.write((priorQ.isEmpty()?0:priorQ.poll().value)+"\n");
            }else{
                Number inputN=new Number();
                inputN.value=input;
                priorQ.add(inputN);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}