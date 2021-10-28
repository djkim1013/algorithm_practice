//BOJ 10866
//2021.10.13
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        String input;
        Deque<Integer> deq=new LinkedList<Integer>();
        StringBuilder answer=new StringBuilder();
        while(t-->0){
            input=br.readLine();
            switch(input.charAt(0)){
                case 'p':{
                    if(input.charAt(2)=='s'){
                        int x=Integer.parseInt(input.substring(input.indexOf(" ")+1));
                        if(input.charAt(5)=='f'){
                            deq.offerFirst(x);
                        }else{
                            deq.offerLast(x);
                        }
                    }else{
                        if(input.charAt(4)=='f'){
                            answer.append(deq.isEmpty()?-1:deq.pollFirst()).append("\n");
                        }else{
                            answer.append(deq.isEmpty()?-1:deq.pollLast()).append("\n");
                        }
                    }
                    break;
                }
                case 's':{
                    answer.append(deq.size()).append("\n");
                    break;
                }
                case 'e':{
                    answer.append(deq.isEmpty()?1:0).append("\n");
                    break;
                }
                case 'f':{
                    answer.append(deq.isEmpty()?-1:deq.getFirst()).append("\n");
                    break;
                }
                case 'b':{
                    answer.append(deq.isEmpty()?-1:deq.getLast()).append("\n");
                }
            }
        }
        System.out.print(answer);
    }
}