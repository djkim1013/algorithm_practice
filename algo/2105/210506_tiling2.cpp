/*
TILING2 : https://algospot.com/judge/problem/read/TILING2
2021.05.06
문제 분석 : 동적 계획법, 오버플로우 방지로 나머지를 구하는 문제
해결 분석 : 문제를 항상 꼼꼼하게 읽자
*/

#include <vector>
#include <iostream>

using namespace std;

const int MOD = 1000000007;
int n;

int count_case(vector<int>& mem,int w)
{
    if(w<=0)return 1;
    int& ret=mem[w];
    if(ret!=-1)return ret;
    ret=(count_case(mem,w-1)+count_case(mem,w-2))%MOD;
    return ret;
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        cin>>n;
        vector<int> mem(n,-1);
        cout<<count_case(mem,n-1)<<endl;
    }
    return 0;
}