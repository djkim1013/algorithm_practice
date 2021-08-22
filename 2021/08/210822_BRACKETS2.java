//AOJ: BRACKETS2
//2021.08.22
//category: 선형자료구조
//review:
//      -deque에서의 peek과 다르게 stack에서의 peek은 배열이 비었을때 예외를 발생시킴

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int test=Integer.parseInt(br.readLine());
        char[][] bracket={{'(',')'},{'{','}'},{'[',']'}};
        for(int t=0;t<test;t++){
            boolean answer=true, done=false;
            char[] str=br.readLine().toCharArray();
            Stack<Character> opened = new Stack<Character>();
            for(char c:str){
                for(char[] pair:bracket){
                    if(c==pair[0]){
                        opened.push(c);
                        break;
                    }
                    if(c==pair[1]){
                        if(!opened.isEmpty()&&opened.peek()==pair[0]){
                            opened.pop();
                            break;
                        }else{
                            answer=false;
                            done=true;
                            break;
                        }
                    }
                }
                if(done) break;
            }
            if(!opened.isEmpty()) answer=false;
            bw.write((answer?"YES":"NO")+"\n");
        }
        bw.flush();
	}
}