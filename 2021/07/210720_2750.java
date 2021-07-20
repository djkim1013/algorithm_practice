//BOJ: 2750
//2021.07.20
//category: 정렬
//review:

import java.io.*;
// import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(in.readLine());
        }
        for(int i=1;i<n;i++){
            int cur = i;
            while(--cur>=0){
                if(arr[cur]<=arr[i]) break;
            }
            if(++cur<i){
                int swap = arr[i];
                for(int j=i;j>cur;j--){
                    arr[j]=arr[j-1];
                }
                arr[cur]=swap;
            }
        }
        for(int i:arr){
            out.write(i+"\n");
        }
        out.flush();
    }
}