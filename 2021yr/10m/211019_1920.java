//BOJ 1920
//2021.10.19
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> data=new HashSet<String>();
        StringBuilder answer=new StringBuilder();
        
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) data.add(st.nextToken());
        
        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            answer.append(data.contains(st.nextToken())?1:0).append("\n");
        }
        System.out.println(answer);
    }
}