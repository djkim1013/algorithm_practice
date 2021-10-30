//BOJ: 9251
//2021.08.01
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static char[] strA;
    static char[] strB;
    static int lenA, lenB;
    static int[][] cache;

    static int lcs(int idxA, int idxB){
        if(idxA==lenA||idxB==lenB) return 0;
        int ret = cache[idxA][idxB];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=idxB;i<lenB;i++){
            if(strA[idxA]==strB[i]){
                ret = Math.max(ret, lcs(idxA+1,i+1)+1);
                break;
            }
        }
        ret = Math.max(ret, lcs(idxA+1,idxB));
        return cache[idxA][idxB] = ret;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        strA = in.readLine().toCharArray();
        lenA = strA.length;
        strB = in.readLine().toCharArray();
        lenB = strB.length;
        cache = new int[lenA][lenB];
        for(int i=0;i<lenA;i++) Arrays.fill(cache[i],-1);
        System.out.print(lcs(0,0));
    }
}