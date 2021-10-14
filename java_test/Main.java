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
        int[] cur=new int[1];
        cur[0]=1;
        for(int i=2;i<=n;i++){
            int[] next=new int[i/2+1];
            next[0]=1;
            for(int j=1;j<cur.length;j++){
                next[j]=(cur[j]+cur[j-1])%MOD;
            }
            if(i%2==0) next[next.length-1]=(2*cur[cur.length-1])%MOD;
            cur=next;
        }
        System.out.println(cur[Math.min(k,n-k-1)]);
    }
}