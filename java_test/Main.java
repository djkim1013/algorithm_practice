//코딩테스트 광탈방지 - 06 게임맵최단거리
//2021.10.26
//category: BFS
//review:

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] maps;
    int n,m;
    
    void searchNext(Queue<int[]> que,int[] target,int d){
        if(target[0]<0||target[0]>=n) return;
        if(target[1]<0||target[1]>=m) return;
        if(maps[target[0]][target[1]]==0) return;
        que.add(target);
        maps[target[0]][target[1]]+=d;
    }
    
    public int solution(int[][] maps) {
        this.maps=maps;
        n=maps.length;
        m=maps[0].length;
        Queue<int[]> que=new LinkedList<int[]>();
        que.add(new int[]{0,0});
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int i=cur[0],j=cur[1];
            if(i==n-1&&j==m-1) return maps[i][j];
            int d=maps[i][j];
            searchNext(que,new int[]{i-1,j},d);
            searchNext(que,new int[]{i+1,j},d);
            searchNext(que,new int[]{i,j-1},d);
            searchNext(que,new int[]{i,j+1},d);
            maps[i][j]=0;
        }
        return -1;
    }
}