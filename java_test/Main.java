//BOJ: 1912
//2021.08.02
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr, cache;

    static int maxContSum(int idx){
        if(idx==n) return 0;
        int answer = cache[idx];
        if(answer>-1) return answer;
        answer = arr[idx];
        answer = Math.max(answer,answer+maxContSum(idx+1));
        return cache[idx] = answer;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bin.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(bin.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cache = new int[n];
        Arrays.fill(cache,-1);
        int answer = maxContSum(0);
        for(int i=1;i<n;i++){
            answer = Math.max(maxContSum(i), answer);
        }
        System.out.print(answer);
    }
}