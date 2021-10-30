//BOJ 1992
//2021.10.13
//category: 분할정복
//review:

//import java.util.*;
import java.io.*;

class Main{
    static String zip(char[][] image,int r,int c,int len){
        char first=image[r][c];
        if(len==1) return Character.toString(first);
        for(int i=r;i<r+len;i++){
            for(int j=c;j<c+len;j++){
                if(image[i][j]!=first){
                    len/=2;
                    StringBuilder ret=new StringBuilder("(");
                    ret.append(zip(image,r,c,len));
                    ret.append(zip(image,r,c+len,len));
                    ret.append(zip(image,r+len,c,len));
                    ret.append(zip(image,r+len,c+len,len)).append(")");
                    return ret.toString();
                }
            }
        }
        return Character.toString(first);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        char[][] image=new char[n][n];
        for(int i=0;i<n;i++){
            image[i]=br.readLine().toCharArray();
        }
        System.out.println(zip(image,0,0,n));
    }
}