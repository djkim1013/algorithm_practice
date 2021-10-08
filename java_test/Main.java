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
        Map<String,ArrayList<String>> closet=new HashMap<String,ArrayList<String>>();
        StringBuilder answer=new StringBuilder();
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            while(n-->0){
                st=new StringTokenizer(br.readLine()," ");
                String item=st.nextToken();
                String kind=st.nextToken();
                if(!closet.containsKey(kind)) closet.put(kind,new ArrayList<String>());
                closet.get(kind).add(item);    
            }
            int allCase=1;
            for(String key:closet.keySet()){
                allCase*=closet.get(key).size();
            }
            answer.append(--allCase).append("\n");
        }
        System.out.print(answer);
    }
}