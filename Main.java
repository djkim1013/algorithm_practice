//BOJ: 15651
//2021.07.23
//category: backtracking
//review:

// import java.util.*;
import java.io.*;

public class Main{
    int n, m;
    void list(int idx,String output){
        if(output.length()==m){
            for(int i=0;i<m;i++){
                System.out.print(output.charAt(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=idx;i<=n;i++){
            list(idx,output+i);
        }
    }
    public static void main(String[] args)throws IOException{
        Main mClass = new Main();
        mClass.n = System.in.read()-'0';
        System.in.read();
        mClass.m = System.in.read()-'0';
        mClass.list(1,"");
    }
}