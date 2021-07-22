//BOJ: 18870
//2021.07.21
//category: 정렬
//review:
//      - 메모리 초과: 2*10^9 크기의 배열은 너무 크다.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] sortArr=arr.clone();
        Arrays.sort(sortArr);
        int range=sortArr[n-1]-sortArr[0]+1;
        int[] count=new int[range];
        int min=sortArr[0];
        for(int i:arr){
            if(count[i-min]==0) count[i-min]++;
        }
        count[0]--;
        for(int i=1;i<range;i++){
            count[i]+=count[i-1];
        }
        for(int i:arr){
            out.write(count[i-min]+" ");
        }
        out.flush();
    }
}