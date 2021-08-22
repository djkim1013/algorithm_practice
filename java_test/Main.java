//AOJ: ITES
//2021.08.22
//category: 선형자료구조
//review:

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int test=Integer.parseInt(br.readLine());
        final String opening="({[", closing=")}]";
        for(int t=0;t<test;t++){
            String answer="YES\n";
            String str=br.readLine();
            Stack<Character> opened = new Stack<Character>();
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(opening.indexOf(c)>-1){
                    opened.push(c);
                }
                if(closing.indexOf(c)>-1){
                    if(!opened.isEmpty()&&opened.peek()==opening.charAt(closing.indexOf(c))){
                        opened.pop();
                    }else{
                        answer="NO\n";
                        break;
                    }
                }
            }
            if(!opened.isEmpty()) answer="NO\n";
            bw.write(answer);
        }
        bw.flush();
	}
}