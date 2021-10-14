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
        int[] arr=new int[(n+1)/2+1];
        arr[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=i/2;j>0;j--){
                arr[j]=(arr[j]+arr[j-1])%MOD;
            }
            if(i%2==1) arr[i/2+1]=arr[i/2];
            //System.out.println(Arrays.toString(arr));
        }
        System.out.println(arr[k>n-k?n-k:k]);
    }
}