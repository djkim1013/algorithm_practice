//BOJ 10816
//2021.10.19
//category: 이분탐색
//review:

import java.io.*;
import java.util.*;

class Main{
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        while(n-->0){
            String key=st.nextToken();
            if(!map.containsKey(key)) map.put(key,0);
            map.put(key,map.get(key)+1);
        }
        n=Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        while(n-->0){
            String target=st.nextToken();
            answer.append(map.containsKey(target)?map.get(target):0).append(" ");
        }
        System.out.println(answer);
    }
}