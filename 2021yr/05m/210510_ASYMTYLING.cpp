/*
ASYMTILING : https://algospot.com/judge/problem/read/ASYMTILING
2021.05.10
문제 분석 : 동적계획법, 재귀의 시작점을 잘 선정해야 한다.
해결 분석 : 1. 홀수와 짝수일때 대칭인 경우의 수가 다름
            2. 함수에서 나머지를 반환하므로 음수 처리 필요
            + 양끝을 다른 방식으로 까는 경우의수를 함수로 해결할 수도 있다.
            양끝을 같은 방식으로 깐 경우->나머지를 재귀함수로 처리
            양끝을 다른 방식으로 깐 경우->모든 경우의 수 합
*/

#include <vector>
#include <iostream>

using namespace std;

vector<int> chache(101,-1);

const int mod=1000000007;
int n;

int tyling(int tyles){
    if(tyles<=1)return 1;
    int& ret=chache[tyles];
    if(ret!=-1)return ret;
    return ret=(tyling(tyles-1)+tyling(tyles-2))%mod;
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        cin>>n;
        if(n<3)
        {
            cout<<0<<endl;
            continue;
        }
        int answer=tyling(n);
        answer-=tyling((n+1)/2-1);
        if(n%2==0)answer-=tyling(n/2);
        while(answer<0)answer+=mod;
        cout<<answer<<endl;
    }
    return 0;
}