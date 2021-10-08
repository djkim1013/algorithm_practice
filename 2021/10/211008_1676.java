//BOJ: 1676
//2021.10.08
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    static public void main(String[] args)throws Exception{
        int c,n=System.in.read()-'0';
        while((c=System.in.read())>='0') n=n*10+c-'0';
        int[][] twoFive=new int[n+1][2];
        for(int i=2;i<=n;i++){
            if(i%2==0){
                twoFive[i][0]=twoFive[i/2][0]+1;
            }
            if(i%5==0){
                twoFive[i][1]=twoFive[i/5][1]+1;
            }
        }
        int two=0,five=0;
        for(int[] arr:twoFive){
            two+=arr[0];
            five+=arr[1];
        }
        System.out.println(Math.min(two,five));
    }
}