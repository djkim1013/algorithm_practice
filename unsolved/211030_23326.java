//BOJ 23326 홍대 경진대회 G
//2021.10.30
//category: 자료구조, 트리
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        LinkedList<Integer> spot=new LinkedList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<n;i++){
            if(st.nextToken().charAt(0)=='1') spot.add(i);
        }
        if(st.nextToken().charAt(0)=='1') spot.add(0);
        StringBuilder answer=new StringBuilder();
        int cur=1;
        while(q-->0){
            st=new StringTokenizer(br.readLine());
            switch(st.nextToken().charAt(0)){
                case '1':{
                    [Integer.parseInt(st.nextToken())%n]^=1;
                    break;
                }
                case '2':{
                    cur+=Integer.parseInt(st.nextToken());
                    cur%=n;
                    break;
                }
                case '3':{
                    for(int i=0;i<n;i++){
                        if(spot[(cur+i)%n]==1){
                            answer.append(i).append("\n");
                            break;
                        }
                        if(i==n-1) answer.append("-1\n");
                    }
                }
            }
        }
        System.out.print(answer);
    }
}