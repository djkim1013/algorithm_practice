/*
섬 연결하기 : https://programmers.co.kr/learn/courses/30/lessons/42861
2021.05.08
문제 분석 : 탐욕법
해결 분석 : 신장트리("크루스칼 알고리즘") 공부 필요.
            가중치가 있는 간선을 가진 노드를 비순환 연결할 때 사용한다. 
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int set[101];

bool comp(vector<int> a,vector<int> b){return a[2]<b[2];}

int find_pnode(int node)
{
    if(set[node]==node)return node;
    return set[node]=find_pnode(set[node]);
}

int solution(int n, vector<vector<int>> costs) {
    int answer=0;
    for(int i=0;i<n;i++)
        set[i]=i;
    sort(costs.begin(),costs.end(),comp);
    for(int i=0;i<costs.size();i++)
    {
        vector<int>& cur=costs[i];
        int b=find_pnode(cur[0]);
        int e=find_pnode(cur[1]);
        if(b!=e)
        {
            answer+=cur[2];
            set[e]=b;
        }
        
    }
    return answer;
}