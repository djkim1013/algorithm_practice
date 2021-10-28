//BOJ: 7568
//2021.07.20
//category: 완전탐색
//review:

import java.io.*;
import java.util.*;

public class Main {
    static int rank(int[][] data,int idx){
        int answer = 1;
        int[] me = data[idx];
        for(int i=0;i<data.length;i++){
            if(i==idx)continue;
            int[] you = data[i];
            if(you[0]>me[0]&&you[1]>me[1]){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[][] data = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            out.write(rank(data,i)+" ");
        }
        out.flush();
    }
}