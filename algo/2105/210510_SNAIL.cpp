/*
SNAIL : https://algospot.com/judge/problem/read/SNAIL
2021.05.10
문제 분석 : 동적 계획법
해결 분석 : float형으로 계산하면 오답. 10e-7이 오차범위=>계산 중간과정도 고려
*/

#include <vector>
#include <iostream>

using namespace std;

vector<vector<double>> chache;
int m,n;

double snail(int day,int h){
    if(day==m)
    {
        return h<n?0.:1.;
    }
    double& ret=chache[day][h];
    if(ret!=-1)return ret;
    return ret=0.25*snail(day+1,h+1)+0.75*snail(day+1,h+2);
}

int main()
{
    int C=0;
    cin>>C;
    cout.precision(8);
    for (int i=0;i<C;i++)
    {
        cin>>n>>m;
        for(int i=0;i<m;i++)chache.push_back(vector<double>(2*m,-1));
        double answer=snail(0,0);
        cout<<fixed<<answer<<endl;
        chache.clear();
    }
    return 0;
}