//BOJ: 1037
//2021.10.06
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int lcm(int[] arr){
        int n=1;
        for(int i:arr){
            while(n<n*i){
                if(n%i==0) break;
                n++;
            }
        }
        if(n==arr[arr.length-1]) n*=arr[0];
        return n;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(lcm(arr));
    }
}