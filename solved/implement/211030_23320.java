//BOJ 23320 홍대 경진대회 A
//2021.10.30
//category: 구현
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        Integer[] scores=new Integer[n];
        for(int i=0;i<n;i++) scores[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int cutR=Integer.parseInt(st.nextToken());
        int cutA=Integer.parseInt(st.nextToken());
        Arrays.sort(scores,Collections.reverseOrder());
        int inR=n*cutR/100;
        int inA=n;
        for(int i=0;i<n;i++){
            if(scores[i]<cutA){
                inA=i;
                break;
            }
        }
        System.out.println(inR+" "+inA);
    }
}