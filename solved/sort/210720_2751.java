//BOJ: 2751
//2021.07.20
//category: 정렬
//review:
//      -내장함수 사용

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        for(int i:arr){
            out.write(i+"\n");
        }
        out.flush();
    }
}