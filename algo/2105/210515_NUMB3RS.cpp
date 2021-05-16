/*
NUMB3RS : https://algospot.com/judge/problem/read/NUMB3RS
2021.05.15
문제 분석 : 동적계획법
해결 분석 : 완전탐색으로 해결하였다. 모든 마을의 확률을 저장하지 않아도 구할 수 있다.
            대신 이 풀이는 답이 필요한 마을 수와 상관없이 한번의 계산만 한다.
*/

#include <vector>
#include <iostream>

using namespace std;

vector<double> chache1(51), chache2(51);
int n;

void cal_chance(const vector<vector<double>>& road, int d){
    if(d==0)return;
    for(int i=0;i<n;i++)
    {
        if(chache1[i]>0.)
        {
            for(int j=0;j<n;j++)
            {
                if(road[i][j]>0.)chache2[j]+=chache1[i]*road[i][j];
            }
        }
    }
    chache1=chache2;
    fill(chache2.begin(),chache2.end(),0.);
    cal_chance(road,d-1);
    return;
}

int main()
{
    int C;
    cin>>C;
    cout.precision(8);
    for (int c=0;c<C;c++)
    {
        int d, p, t;
        cin>>n>>d>>p;

        vector<vector<int>> A(n,vector<int>(n,0));
        vector<vector<double>> road(n,vector<double>(n,0.));

        fill(chache1.begin(),chache1.end(),0.);
        fill(chache2.begin(),chache2.end(),0.);

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                cin>>A[i][j];
        }

        for(int i=0;i<n;i++)
        {
            int total=0;
            for(int j=0;j<n;j++)if(A[i][j]==1)total++;
            for(int j=0;j<n;j++)if(A[i][j]==1)road[i][j]=1./total;
        }
        chache1[p]=1.;

        cal_chance(road,d);

        cin>>t;
        for(int i=0;i<t;i++)
        {
            int target;
            cin>>target;
            cout<<fixed<<chache1[target]<<" ";
        }
        cout<<endl;
    }
    return 0;
}