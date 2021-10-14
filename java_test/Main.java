//BOJ 11444
//2021.10.14
//category: 분할정복
//review:

//import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws Exception{
        long n=Long.parseLong((new BufferedReader(new InputStreamReader(System.in))).readLine());
        final int MOD=1000000007;
        int answer=0;
        int temp1=0,temp2=1;
        for(long i=0;i<n;i++){
            answer=temp1+temp2;
            temp2=temp1;
            temp1=answer%=MOD;
        }
        System.out.print(answer);
    }
}