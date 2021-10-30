//BOJ: 15650
//2021.07.22
//category: backtracking
//review:

// import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    public static void list(int idx,String output){
        if(idx>n||output.length()==m){
            if(output.length()<m)return;
            for(int i=0;i<m;i++){
                System.out.print(output.charAt(i)+" ");
            }
            System.out.println();
            return;
        }
        list(idx+1,output+idx);
        list(idx+1,output);
    }

    public static void main(String[] args)throws IOException{
        n = System.in.read()-'0';
        System.in.read();
        m = System.in.read()-'0';
        list(1,"");
    }
}