//BOJ: 10989
//2021.07.20
//category: 정렬
//review:
//      - 카운팅 정렬 구현

import java.io.*;
// import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        int[] count = new int[10001];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(in.readLine());
        }
        for(int i=0;i<n;i++){
            if(arr[i]<0) continue;
            int v = arr[i];
            for(int j=i;j<n;j++){
                if(arr[j]==v){
                    count[v]++;
                    arr[j]=-1;
                }
            }
        }
        for(int i=0;i<10001;i++){
            if(count[i]==0)continue;
            for(int j=0;j<count[i];j++){
                out.write(i+"\n");
            }
        }
        out.flush();
    }
}