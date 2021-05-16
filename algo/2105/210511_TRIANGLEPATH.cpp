/*
TRIANGLEPATH : https://algospot.com/judge/problem/read/TRIANGLEPATH
2021.05.11
문제 분석 : 동적계획법
해결 분석 : 지역변수로 선언하는 것과 전역변수로 선언해서 매번 초기화하는 것 중 뭐가 이득인지 모르겠음
*/

#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int n;

int find_max_path(vector<vector<int>>& triangle,vector<int>& chache1,vector<int>& chache2,int idx){
    if(idx==n){
        return *max_element(chache1.begin(),chache1.end());
    }
    vector<int> chache_nx(101,0);
    for(int i=1;i<=idx+1;i++)
        chache2[i]=triangle[idx][i-1]+max(chache1[i-1],chache1[i]);
    chache1=chache2;
    return find_max_path(triangle,chache1,chache2,idx+1);
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        cin>>n;
        vector<int> chache1(n+1,0),chache2(n+1,0);
        vector<vector<int>> triangle(n,vector<int>(0));
        for(int i=0;i<n;i++)
            for(int j=0;j<=i;j++)
            {
                int input;
                cin>>input;
                triangle[i].push_back(input);
        }
        cout<<find_max_path(triangle,chache1,chache2,0)<<endl;
    }
    return 0;
}