//BOJ: 11054
//2021.07.31
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int[] cache1, cache2;
    static int n;

    static int maxBitonic(){
        int ret=0;
        for(int i=0;i<n;i++){
            int left = maxPartialLeft(i);
            int right = maxPartialRight(i);
            ret = Math.max(left+right,ret);
        }
        return ++ret;
    }

    static int maxPartialLeft(int idx){
        int ret = cache1[idx];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=idx-1;i>=0;i--){
            if(arr[i]<arr[idx]) ret=Math.max(maxPartialLeft(i)+1,ret);
        }
        return cache1[idx]=ret;
    }

    static int maxPartialRight(int idx){
        int ret = cache2[idx];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=idx+1;i<n;i++){
            if(arr[i]<arr[idx]) ret=Math.max(maxPartialRight(i)+1,ret);
        }
        return cache2[idx]=ret;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cache1 = new int[n];
        Arrays.fill(cache1,-1);
        cache2 = new int[n];
        Arrays.fill(cache2,-1);
        System.out.println(maxBitonic());
    }
}