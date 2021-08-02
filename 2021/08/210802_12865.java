//BOJ: 12865
//2021.08.02
//category: dynamic programming
//review:
//      -선택한 아이템의 종류는 상관 없는 경우의 메모이제이션

import java.util.*;
import java.io.*;

public class Main{
    static int weight, n;
    static int[][] items, cache;

    static int maxValue(int idx, int remain){
        if(idx==n||remain==0){
            return 0;
        } 
        int ret = cache[idx][remain];
        if(ret>-1){
            return ret;
        }
        int w = items[idx][0];
        int v = items[idx][1];
        ret = maxValue(idx+1,remain);
        if(remain>=w){
            ret = Math.max(ret, maxValue(idx+1,remain-w)+v);
        }
        return cache[idx][remain]=ret;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bin.readLine());
        
        n = Integer.parseInt(st.nextToken());
        weight = Integer.parseInt(st.nextToken());
        items = new int[n][2];
        cache = new int[n][weight+1];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bin.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(cache[i],-1);
        }
        System.out.print(maxValue(0,weight));
    }
}