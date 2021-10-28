//BOJ: 15652
//2021.07.23
//category: backtracking
//review:

// import java.util.*;
import java.io.*;

public class Main{
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static void list(int idx,String output)throws IOException{
        if(output.length()==m){
            for(int i=0;i<m;i++){
                out.write(output.charAt(i)+" ");
            }
            out.newLine();
            return;
        }
        for(int i=idx;i<=n;i++){
            list(i,output+i);
        }
    }
    public static void main(String[] args)throws IOException{
        n = System.in.read()-'0';
        System.in.read();
        m = System.in.read()-'0';
        list(1,"");
        out.flush();
    }
}