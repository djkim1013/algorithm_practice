/*
POLY : https://algospot.com/judge/problem/read/POLY
2021.05.14
문제 분석 : 동적계획법
해결 분석 : 점화식을 정확히 이해하여 재귀함수를 작성한다.
*/

#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> chache(101,vector<int>(101,-1));
const int mod=10000000;

int count_case(int n, int pre){
    if(n==pre)return 1;
    int& ret=chache[n][pre];
    if(ret!=-1)return ret;
    ret=0;
    for(int i=1;i+pre<=n;i++)
    {
        int add=((i+pre-1)*count_case(n-pre,i))%mod;
        ret=(ret+add)%mod;
    }
    return ret;
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        int n;
        cin>>n;
        int answer=0;
        for(int i=1;i<=n;i++)answer=(answer+count_case(n,i))%mod;
        cout<<answer<<endl;
    }
    return 0;
}