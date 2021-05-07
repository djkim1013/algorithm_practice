/*
조이스틱 : https://programmers.co.kr/learn/courses/30/lessons/42860
2021.05.07
문제 분석 : 탐욕법
해결 분석 : 조건을 간결화하려다가 빼먹는 사례를 만들지 말 것
*/

#include <string>
#include <vector>

using namespace std;

int n;

int min_lr(vector<int>& updown,int idx)
{
    int m=0xfffffff;
    int idx_next=idx;
    bool allzero=true;
    updown[idx]=0;
    for(int i=0;i<n;i++)
    {
        if(updown[i]>0)
        {
            int lr=idx-i>0?idx-i:i-idx;
            lr=lr<n-lr?lr:n-lr;
            if(m>lr)
            {
                m=lr;
                idx_next=i;
            }
            allzero=false;
        }
    }
    if(allzero)return 0;
    return m+min_lr(updown,idx_next);
}

int solution(string name) {
    int answer = 0;
    n=name.size();
    vector<int> updown(n);
    for(int i=0;i<n;i++)
    {
        int a=name[i]-'A';
        a=min(a,'Z'-name[i]+1);
        updown[i]=a;
        answer+=a;
    }
    if(n<=1)return answer;
    answer+=min_lr(updown,0);
    return answer;
}