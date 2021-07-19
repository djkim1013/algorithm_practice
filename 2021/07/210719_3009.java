//BOJ: 3009
//2021.07.19
//category: 기본수학
//review:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] x = new int[3];
        int[] y = new int[3];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer=new int[2];
        if(x[0]==x[1]){
            answer[0]=x[2];
        }else if(x[0]==x[2]){
            answer[0]=x[1];
        }else{
            answer[0]=x[0];
        }
        if(y[0]==y[1]){
            answer[1]=y[2];
        }else if(y[0]==y[2]){
            answer[1]=y[1];
        }else{
            answer[1]=y[0];
        }
        out.write(answer[0]+" "+answer[1]);
        out.flush();
    }
}