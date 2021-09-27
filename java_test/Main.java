//AOJ: MEETINGROOM
//2021.09.27
//category: 그래프의 깊이우선탐색
//review:

import java.util.*;
import java.io.*;

public class Main {
    

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        while(c-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<int[]> times=new ArrayList<int[]>();
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int s=Integer.parseInt(st.nextToken());
                int e=Integer.parseInt(st.nextToken());
                times.add(new int[]{s,e});
                s=Integer.parseInt(st.nextToken());
                e=Integer.parseInt(st.nextToken());
                times.add(new int[]{s,e});
            }
            
        }   
    }
}
