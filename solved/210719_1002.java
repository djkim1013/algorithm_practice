//BOJ: 1002
//2021.07.19
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(in.readLine());
        for(int t=0;t<test;t++){
            int[] a=new int[3];
            int[] b=new int[3];
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int i=0;i<3;i++){
                a[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<3;i++){
                b[i]=Integer.parseInt(st.nextToken());
            }
            if(a[0]==b[0]&&a[1]==b[1]){
                if(a[2]==b[2]) out.write("-1\n");
                else out.write("0\n");
                continue;
            }
            int dist = (a[0]-b[0])*(a[0]-b[0]);
            dist += (a[1]-b[1])*(a[1]-b[1]);
            if((a[2]+b[2])*(a[2]+b[2])<dist||
                (a[2]-b[2])*(a[2]-b[2])>dist){
                out.write("0\n");
                continue;
            }
            if((a[2]+b[2])*(a[2]+b[2])==dist||
                (a[2]-b[2])*(a[2]-b[2])==dist){
                out.write("1\n");
                continue;
            }
            out.write("2\n");
        }
        out.flush();
    }
}