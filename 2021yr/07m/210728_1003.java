//BOJ: 1003
//2021.07.28
//category: dynamic programming
//review:

//import java.util.*;
import java.io.*;

public class Main{
    static int[][] cache=new int[41][2];
    static int[] fibonacci(int n){
        int[] ret=cache[n];
        if(ret[0]>=0) return ret;
        if(n==0){
            ret[0]=1;
            ret[1]=0;
            cache[0]=ret;
            return ret;
        }
        if(n==1){
            ret[0]=0;
            ret[1]=1;
            cache[1]=ret;
            return ret;
        }
        ret[0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
        ret[1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
        cache[n]=ret;
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int test=Integer.parseInt(in.readLine());
        for(int i=0;i<41;i++){
            cache[i][0]=-1;
            cache[i][1]=-1;
        }
        for(int t=0;t<test;t++){
            int n=Integer.parseInt(in.readLine());
            int[] answer=fibonacci(n);
            out.write(answer[0]+" "+answer[1]);
            out.newLine();
        }
        out.flush();
    }
}