/*
가장 먼 노드 : https://programmers.co.kr/learn/courses/30/lessons/49189
2021.04.24
문제 분석 : 넓이 우선 탐색(BFS)
해결 분석 : 큐에서 .pop() 하는 타이밍 주의
*/

#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    queue<int> q;
    vector<vector<bool>> nodes(n,vector<bool>(n,false));
    vector<int> visited(n,0);
    int distance=0,max_distance=0;
    
    for(auto i:edge){
        nodes[i[0]-1][i[1]-1]=true;
        nodes[i[1]-1][i[0]-1]=true;
    }
    
    q.push(0);
    
    while(!q.empty()){
        int curr=q.front();
        distance=visited[curr]+1;
        q.pop();
        for(int i=1;i<n;i++){
            if(nodes[curr][i]&&!visited[i]){
                q.push(i);
                visited[i]=distance;
            }
        }
    }
    for(auto v:visited){
        if(max_distance<v){
            answer=1;
            max_distance=v;
            continue;
        }
        if(v<max_distance){continue;}
        answer++;
    }
    return answer;
}