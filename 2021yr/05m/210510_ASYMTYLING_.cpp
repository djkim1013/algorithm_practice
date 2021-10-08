/*
ASYMTILING : https://algospot.com/judge/problem/read/ASYMTILING
2021.05.10
문제 분석 : 동적계획법, 재귀의 시작점을 잘 선정해야 한다.
해결 분석 : 양끝을 같은 방식으로 깐 경우->나머지를 재귀함수로 처리
            양끝을 다른 방식으로 깐 경우->모든 경우의 수 합
*/

#include <vector>
#include <iostream>

using namespace std;

vector<int> chache1(101,-1), chache2(101,-1);

const int mod=1000000007;

int tyling(int tyles){
    if(tyles<=1)return 1;
    int& ret=chache1[tyles];
    if(ret!=-1)return ret;
    return ret=(tyling(tyles-1)+tyling(tyles-2))%mod;
}                                                

int asymtyling(int tyles){
    if(tyles<=2)return 0;
    int& ret=chache2[tyles];
    if(ret!=-1)return ret;
    ret=asymtyling(tyles-2)%mod;
    ret=(ret+asymtyling(tyles-4))%mod;
    ret=(ret+tyling(tyles-3))%mod;
    ret=(ret+tyling(tyles-3))%mod;
    return ret;
}

int main()
{
    int C=0;
    int n=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        cin>>n;
        cout<<asymtyling(n)<<endl;
    }
    return 0;
}