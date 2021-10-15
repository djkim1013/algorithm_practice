//BOJ 6549
//2021.10.15
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder answer=new StringBuilder();
        while((input=br.readLine()).charAt(0)!='0'){
            StringTokenizer st=new StringTokenizer(input);
            int n=Integer.parseInt(st.nextToken());
            long[] histogram=new long[n];
            for(int i=0;i<n;i++) histogram[i]=Long.parseLong(st.nextToken());
            long max=-1;
            for(int i=0;i<n;i++){
                long h=histogram[i];
                long temp=h;
                int j;
                for(j=i-1;j>=0;j--){
                    if(histogram[j]<h) break;
                    temp+=h;
                }
                for(j=i+1;j<n;j++){
                    if(histogram[j]<h) break;
                    temp+=h;
                }
                max=Math.max(temp,max);
            }
            answer.append(max).append("\n");
        }
        System.out.print(answer);
    }
}