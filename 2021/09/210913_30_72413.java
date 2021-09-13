/*
 *  2021 kakao blind recruitment
 *  합승 택시 요금
 */

import java.util.*;

class Solution {
    final int BIGNUM = Integer.MAX_VALUE>>2;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = BIGNUM;
        int[][] edges=new int[n+1][n+1];
        for(int i=0;i<n+1;i++) Arrays.fill(edges[i],BIGNUM);
        for(int i=0;i<n+1;i++) edges[i][i]=0;
        for(int i=0;i<fares.length;i++){
            edges[fares[i][0]][fares[i][1]]=fares[i][2];
            edges[fares[i][1]][fares[i][0]]=fares[i][2];
        }
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(edges[i][j]>edges[i][k]+edges[k][j])
                        edges[i][j]=edges[i][k]+edges[k][j];
                } 
            }
        }
        for(int i=1;i<n+1;i++){
            answer=Math.min(answer,edges[s][i]+edges[i][a]+edges[i][b]);
        }
        return answer;
    }
}