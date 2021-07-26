//BOJ: 14889
//2021.07.26
//category: backtracking
//review:

import java.util.*;
import java.io.*;

public class Main{
    static int min=40000;
    static int n;
    static int[][] input;
    static void divTeam(int[] team,int idx){
        if(idx==n){
            // for(int i:team){
            //     System.out.print(i+" ");
            // }
            // System.out.println();
            int ret = 0;
            for(int i=0;i<n/2;i++){
                int ii=team[i];
                for(int j=0;j<n/2;j++){
                    int jj=team[j];
                    ret+=input[ii][jj];
                }
            }
            for(int i=n/2;i<n;i++){
                int ii=team[i];
                for(int j=n/2;j<n;j++){
                    int jj=team[j];
                    ret-=input[ii][jj];
                }
            }
            if(ret<0)ret=-ret;
            min=Math.min(ret,min);
            return;
        }
        for(int i=1;i<n;i++){
            if(team[i]>0)continue;
            team[i]=idx;
            divTeam(team,idx+1);
            team[i]=0;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        input = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int j=0;j<n;j++){
                input[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        divTeam(new int[n],1);
        System.out.println(min);
    }
}