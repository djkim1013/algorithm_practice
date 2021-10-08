//BOJ: 2565
//2021.08.01
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int[][] lines;
    static int[] cache;
    static int n;

    static void mergeSort(int start,int end){
        for(int i=start+1;i<=end;i++){
            int cur=i;
            while(--cur>=start){
                if(lines[cur][0]<lines[i][0]){
                    break;
                }
            }
            if(++cur<i){
                int swap1 = lines[i][0];
                int swap2 = lines[i][1];
                for(int j=i;j>cur;j--){
                    lines[j][0] = lines[j-1][0];
                    lines[j][1] = lines[j-1][1];
                }
                lines[cur][0] = swap1;
                lines[cur][1] = swap2;
            }
        }
    }
    static void sortLines(int start, int end){
        if(start==end) return;
        int mid = start+end;
        mid /= 2;
        sortLines(start,mid);
        sortLines(mid+1,end);
        mergeSort(start,end);
    }

    static int maxUncrossed(int idx){
        if (idx==n){
            return 0;
        }
        if(idx==-1){
            int ret = 0;
            for(int i=idx+1;i<n;i++){
                ret = Math.max(ret, maxUncrossed(i));
            }
            return ret;
        }
        int ret = cache[idx];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=idx+1;i<n;i++){
            if(lines[idx][1]<lines[i][1]){
                ret = Math.max(ret, maxUncrossed(i));
            }
        }
        cache[idx] = ++ret;
        return ret;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        lines = new int[n][2];
        cache = new int[n];
        Arrays.fill(cache,-1);
        for(int i=0;i<n;i++){
            StringTokenizer input = new StringTokenizer(in.readLine());
            lines[i][0] = Integer.parseInt(input.nextToken());
            lines[i][1] = Integer.parseInt(input.nextToken());
        }
        sortLines(0,n-1);
        System.out.print(n-maxUncrossed(-1));
    }
}