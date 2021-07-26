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
        if(team.length==n/2){
            int ret = 0;
            for(int i=0;i<n;i++){
                int sum = 0;
                for(int j=0;j<n;j++){
                    sum+=input[i][j];
                }
                for(int j:team){
                    if(j==i){
                        sum*=-1;
                        break;
                    }
                }
                ret+=sum;
            }
            if(ret*ret<min*min) min = ret;
            return;
        }
        if(idx==n) return;
        int[] newTeam = new int[team.length+1];
        for(int i=0;i<team.length;i++) newTeam[i]=team[i];
        for(int i=idx;i<n;i++){
            for(int j:team) if(j==i) continue;
            newTeam[idx]=i;
            divTeam(newTeam,idx+1);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        input = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                input[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        divTeam(null,0);
        System.out.println(min);
    }
}