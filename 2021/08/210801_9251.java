
//BOJ: 9251
//2021.08.01
//category: dynamic programming
//review:

import java.util.*;
import java.io.*;

public class Main{
    static String strA;
    static String strB;
    static int lenA, lenB;
    static int[][] cache;

    static int lcs(int i1, int i2){
        if(i1==-1){
            int ret = 0;
            for(int i=0;i<lenA;i++){
                int j=i2;
                while(++j<lenB){
                    if(strA.charAt(i)==strB.charAt(j)){
                        ret = Math.max(ret, lcs(i,j));
                        break;
                    }
                }
            }
            return ret;
        }
        int ret = cache[i1][i2];
        if(ret>-1) return ret;
        ret = 0;
        for(int i=i1+1;i<lenA;i++){
            int j=i2;
            while(++j<lenB){
                if(strA.charAt(i)==strB.charAt(j)){
                    ret = Math.max(ret, lcs(i,j));
                    break;
                }
            }
        }
        return cache[i1][i2] = ++ret;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        strA = in.readLine();
        lenA = strA.length();
        strB = in.readLine();
        lenB = strB.length();
        cache = new int[lenA][lenB];
        for(int i=0;i<lenA;i++) Arrays.fill(cache[i],-1);
        System.out.print(lcs(-1,-1));
    }
}