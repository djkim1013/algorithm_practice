//BOJ 11866
//2021.10.12
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        String input=new BufferedReader(new InputStreamReader(System.in)).readLine();
        int n=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int k=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        List<Integer> round=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            round.add(i);
        }
        StringBuilder answer=new StringBuilder("<");
        int cur=0;
        while(n>1){
            cur=(cur+k-1)%(n--);
            answer.append(round.remove(cur)).append(", ");
        }
        answer.append(round.get(0)).append(">");
        System.out.println(answer);
    }
}