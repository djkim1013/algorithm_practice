//BOJ 18258
//2021.10.12
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();
        Queue<Integer> que=new LinkedList<Integer>();
        int back=-1;
        while(n-->0){
            String input=br.readLine();
            switch(input.charAt(0)){
                case 'e':{
                    answer.append(que.isEmpty()?"1\n":"0\n");
                    break;
                }
                case 's':{
                    answer.append(que.size()).append("\n");
                    break;
                }
                case 'f':{
                    answer.append(que.isEmpty()?-1:que.peek()).append("\n");
                    break;
                }
                case 'b':{
                    answer.append(que.isEmpty()?-1:back).append("\n");
                    break;
                }
                case 'p':{
                    if(input.charAt(1)=='u'){
                        back=Integer.parseInt(input.substring(5));
                        que.offer(back);
                    }else{
                        answer.append(que.isEmpty()?-1:que.poll()).append("\n");
                    }
                }
            }
        }
        System.out.print(answer);
    }
}