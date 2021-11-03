/*
 *  2021 kakao blind recruitment
 *  카드 짝 맞추기
 */

import java.util.*;

class Solution {
    int answer=1000;
    int[][] board;
    int[] start;
    Map<Integer,ArrayList<int[]>> pairs=new HashMap<Integer,ArrayList<int[]>>();
    
    public int solution(int[][] board, int r, int c) {
        this.board=board;
        this.start=new int[]{r,c};
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j]>0){
                    int v=board[i][j];
                    if(!pairs.containsKey(v))
                        pairs.put(v,new ArrayList<int[]>());
                    pairs.get(v).add(new int[]{i,j});
                }
            }
        }
        permutation(new int[pairs.size()],0,new HashSet<Integer>());
        return answer+pairs.size()*2;
    }
    
    void permutation(int[] order,int idx,HashSet<Integer> visited){
        if(idx==order.length){
            answer=Math.min(findMinDist(order),answer);
        }
        for(int key:pairs.keySet()){
            if(visited.contains(key)) continue;
            visited.add(key);
            order[idx]=key;
            permutation(order,idx+1,visited);
            order[idx]=0;
            visited.remove(key);
        }
    }
    
    int findMinDist(int[] order){
        int dist=0;
        int[] cur=this.start;
        int[][] board=new int[4][4];
        for(int i=0;i<4;i++) board[i]=this.board[i].clone();
        for(int i:order){
            int[] p1=pairs.get(i).get(0);
            int[] p2=pairs.get(i).get(1);
            int d1=bfs(cur,p1,board)+bfs(p1,p2,board);
            int d2=bfs(cur,p2,board)+bfs(p2,p1,board);
            if(d1<d2){
                dist+=d1;
                cur=p2;
            }else{
                dist+=d2;
                cur=p1;
            }
            board[p1[0]][p1[1]]=0;
            board[p2[0]][p2[1]]=0;
        }
        return dist;
    }
    
    int bfs(int[] start,int[] end,int[][] board){
        Queue<int[]> q=new LinkedList<int[]>();
        q.offer(new int[]{start[0],start[1],0});
        boolean[][] visited=new boolean[4][4];
        visited[start[0]][start[1]]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==end[0]&&cur[1]==end[1]) return cur[2];
            int r=cur[0];
            int c=cur[1];
            int dist=cur[2];
            if(r>0){
                if(!visited[r-1][c]){
                    q.offer(new int[]{r-1,c,dist+1});
                    visited[r-1][c]=true;
                }
                for(int i=r-1;i>=0;i--){
                    if(board[i][c]>0){
                        if(visited[i][c]) break;
                        q.offer(new int[]{i,c,dist+1});
                        visited[i][c]=true;
                        break;
                    }
                    if(i==0){
                        q.offer(new int[]{i,c,dist+1});
                        visited[i][c]=true;
                    }
                }
            }
            if(r<3){
                if(!visited[r+1][c]){
                    q.offer(new int[]{r+1,c,dist+1});
                    visited[r+1][c]=true;
                }
                for(int i=r+1;i<4;i++){
                    if(board[i][c]>0){
                        if(visited[i][c]) break;
                        q.offer(new int[]{i,c,dist+1});
                        visited[i][c]=true;
                        break;
                    }
                    if(i==3){
                        q.offer(new int[]{i,c,dist+1});
                        visited[i][c]=true;
                    }
                }
            }
            if(c>0){
                if(!visited[r][c-1]){
                    q.offer(new int[]{r,c-1,dist+1});
                    visited[r][c-1]=true;
                }
                for(int i=c-1;i>=0;i--){
                    if(board[r][i]>0){
                        if(visited[r][i]) break;
                        q.offer(new int[]{r,i,dist+1});
                        visited[r][i]=true;
                        break;
                    }
                    if(i==0){
                        q.offer(new int[]{r,i,dist+1});
                        visited[r][i]=true;
                    }
                }
            }
            if(c<3){
                if(!visited[r][c+1]){
                    q.offer(new int[]{r,c+1,dist+1});
                    visited[r][c+1]=true;
                }
                for(int i=c+1;i<4;i++){
                    if(board[r][i]>0){
                        if(visited[r][i]) break;
                        q.offer(new int[]{r,i,dist+1});
                        visited[r][i]=true;
                        break;
                    }
                    if(i==3){
                        q.offer(new int[]{r,i,dist+1});
                        visited[r][i]=true;
                    }
                }
            }
        }
        return -1; 
    }
}