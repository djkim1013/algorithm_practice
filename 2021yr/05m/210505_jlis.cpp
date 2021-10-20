/*
JLIS : https://algospot.com/judge/problem/read/JLIS
2021.05.05
문제 분석 : 동적계획법
해결 분석 : 각각의 수열에서 각 요소에서 시작하는 가장 긴 부분증가수열을 구하는 함수를
        만든 후 탐욕법을 사용하려 했으나, 같은 요소에서 시작하지만 서로 다른 부분수열
        이 저장 되지 않는 문제가 발생하였고, 이 방식대로 오류가 나지 않게끔 수저오하면
        중복이 발생하는 탐욕법과 같아진다. 교재의 방식대로 구현하여 해결하였다.
*/

#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

const int NEGI=numeric_limits<int>::min();
int n,m;

int find_JLIS(vector<int>& A,vector<int>& B,vector<vector<int>>& mem,int ia,int ib)
{
    int& ret=mem[ia+1][ib+1];
    if(ret>-1)return ret;
    ret=2;
    int a=(ia==-1?NEGI:A[ia]);
    int b=(ib==-1?NEGI:B[ib]);
    int maxE=max(a,b);
    for(int i=ia+1;i<n;i++)
        if(maxE<A[i])
            ret=max(ret,find_JLIS(A,B,mem,i,ib)+1);
    for(int i=ib+1;i<m;i++)
        if(maxE<B[i])
            ret=max(ret,find_JLIS(A,B,mem,ia,i)+1);
    return ret;
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        cin>>n>>m;
        vector<int> a(n,0),b(m,0);
        vector<vector<int>> mem(n+1,vector<int>(m+1,-1));
        for(int j=0;j<n;j++) cin>>a[j];
        for(int j=0;j<m;j++) cin>>b[j];
        cout<<find_JLIS(a,b,mem,-1,-1)-2<<endl;
    }
    return 0;
}