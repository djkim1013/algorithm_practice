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
        StringTokenizer st=null;
        Queue<Integer> que=new LinkedList<Integer>();
        int back=-1;
        while(n-->0){
            st=new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":{
                    back=Integer.parseInt(st.nextToken());
                    que.offer(back);
                    break;
                }
                case "empty":{
                    answer.append(que.isEmpty()?"1\n":"0\n");
                    break;
                }
                case "size":{
                    answer.append(que.size()).append("\n");
                    break;
                }
                case "front":{
                    if(que.isEmpty()) answer.append("-1\n");
                    else answer.append(que.peek()).append("\n");
                    break;
                }
                case "back":{
                    answer.append(back).append("\n");
                    break;
                }
                default :{
                    if(que.isEmpty()) answer.append("-1\n");
                    else{
                        answer.append(que.poll()).append("\n");
                        if(que.isEmpty()) back=-1;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}