//BOJ: 1912
//2021.08.02
//category: dynamic programming
//review:
//      -재귀/메모이제이션을 남발하지 말 것

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine());
        int[] arr = new int[n]; 
        StringTokenizer st = new StringTokenizer(bin.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i-1]>0&&arr[i]+arr[i-1]>0) arr[i] += arr[i-1];
            answer = Math.max(arr[i], answer);
        }
        System.out.print(answer);
    }
}