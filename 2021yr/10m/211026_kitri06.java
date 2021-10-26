//코딩테스트 광탈방지 - 06 게임맵최단거리
//2021.10.26
//category: BFS
//review:

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] maps;
    int n,m;
    
    public int solution(int[][] maps) {
        this.maps=maps;
        n=maps.length;
        m=maps[0].length;
        Queue<int[]> que=new LinkedList<int[]>();
        que.add(new int[]{0,0});
        int[][] moves=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!que.isEmpty()){
            int[] cur=que.poll();
            if(cur[0]==n-1&&cur[1]==m-1) return maps[n-1][m-1];
            int d=maps[cur[0]][cur[1]];
            for(int[] move:moves){
                int i=cur[0]+move[0], j=cur[1]+move[1];
                if(i<0||i>=n||j<0||j>=m) continue;
                if(maps[i][j]==1){
                    que.add(new int[]{i,j});
                    maps[i][j]=d+1;
                }
            }
            maps[cur[0]][cur[1]]=0;
        }
        return -1;
    }
}