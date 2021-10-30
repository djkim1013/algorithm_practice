//BOJ: 14889
//2021.07.28
//category: backtracking
//review:
//      -시간 초과: 중복 경우의 수 제거

import java.util.*;

import java.io.*;

public class Main{
    static int min=40000;
    static int n;
    static int[][] input;
    static void divTeam(int[] team,int idx,int pre){
        if(idx==n/2){
            for(int i=1;i<n;i++){
                for(int j=1;j<n;j++){
                    if(team[j]==i) break;
                    if(team[j]==0){
                        team[j]=i;
                        break;
                    }
                }
            }
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
            // System.out.println(ret);
            min=Math.min(ret,min);
            return;
        }
        for(int i=pre;i<n;i++){
            team[idx]=i;
            divTeam(team,idx+1,i+1);
            for(int j=idx;j<n;j++)team[j]=0;
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
        divTeam(new int[n],1,1);
        System.out.println(min);
    }
}