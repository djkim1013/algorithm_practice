//BOJ: 11053
//2021.07.30
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int[] cache;
    static int n;

    static int maxPartial(int idx){
        if(idx==n) return 0;
        int ret = 0;
        if(idx==-1){
            for(int i=0;i<n;i++){
                ret=Math.max(maxPartial(i)+1,ret);
            }
            return ret; 
        }
        ret = cache[idx];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=idx+1;i<n;i++){
            if(arr[i]>arr[idx]) ret=Math.max(maxPartial(i)+1,ret);
        }
        return cache[idx]=ret;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cache = new int[n];
        Arrays.fill(cache,-1);
        System.out.println(maxPartial(-1));
    }
}