//BOJ 11401
//2021.10.13
//category: 분할정복
//review:

//import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        String input=(new BufferedReader(new InputStreamReader(System.in))).readLine();
        int n=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int k=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        final int MOD=1000000007;
        int[] cur=new int[n+1];
        cur[0]=1;
        for(int i=1;i<=n;i++){
            int[] next=new int[i+1];
            for(int j=0;j<i;j++){
                next[j]=(cur[j]+cur[j+1])%MOD;
            }
            cur=next;
        }
        System.out.println(cur[k]);
    }
}