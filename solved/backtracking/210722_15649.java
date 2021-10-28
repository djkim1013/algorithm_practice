//BOJ: 15649
//2021.07.22
//category: backtracking
//review:

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static void list(int used,String output){
        if(output.length()==m){
            for(int i=0;i<m;i++){
                System.out.print(output.charAt(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if((used&(1<<i))>0)continue;
            list(used+(1<<i),output+i);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        list(0,"");
    }
}