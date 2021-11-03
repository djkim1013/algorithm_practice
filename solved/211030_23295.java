//BOJ 23295 APC - D
//2021.10.30
//category: 누적합, 스위핑
//review:

import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] timeline=new int[100001];
        String input=br.readLine();
        int n=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int t=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        int last=0;
        while(n-->0){
            int k=Integer.parseInt(br.readLine());
            while(k-->0){
                input=br.readLine();
                int s=Integer.parseInt(input.substring(0,input.indexOf(" ")));
                int e=Integer.parseInt(input.substring(input.indexOf(" ")+1));
                for(int i=s;i<e;i++) timeline[i]++;
                last=Math.max(last,e);
            }
        }
        int maxStart=0;
        long maxValue=0;
        for(int i=0;i<t;i++){
            maxValue+=timeline[i];
        }
        long temp=maxValue;
        for(int i=1;i<=last-t;i++){
            temp=temp-timeline[i-1]+timeline[i+t-1];
            if(maxValue<temp){
                maxStart=i;
                maxValue=temp;
            }
        }
        System.out.println(maxStart+" "+(maxStart+t));
    }
}