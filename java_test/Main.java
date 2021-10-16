//BOJ 6549
//2021.10.16
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    static long distance(int[] a,int[] b){
        long ret=(a[0]-b[0])*(a[0]-b[0]);
        ret+=(a[1]-b[1])*(a[1]-b[1]);
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            String input=br.readLine();
            arr[i][0]=Integer.parseInt(input.substring(0,input.indexOf(" ")));
            arr[i][1]=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        }
        long answer=2*20000*20000;
        for(int i=0;i+1<n;i++){
            for(int j=i+1;j<n;j++){
                answer=Math.min(answer,distance(arr[i],arr[j]));
            }
        }
        System.out.println(answer);
    }
}