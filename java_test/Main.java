//BOJ: 9375
//2021.10.08
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String,Integer> closet;
        StringBuilder answer=new StringBuilder();
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            closet=new HashMap<String,Integer>();
            while(n-->0){
                st=new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String key=st.nextToken();
                if(!closet.containsKey(key)) closet.put(key,1);
                closet.put(key,closet.get(key)+1);    
            }
            int allCase=1;
            for(String key:closet.keySet()){
                allCase*=closet.get(key);
            }
            answer.append(--allCase).append("\n");
        }
        System.out.print(answer);
    }
}