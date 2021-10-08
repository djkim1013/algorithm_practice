/*
WILDCARD : https://algospot.com/judge/problem/read/WILDCARD
2021.05.03.
문제 분석 : 동적계획법
해결 분석 : 중복 제거 만큼 놓치는 경우를 생각할 것
*/

#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool srch_wildcard(string& w,string& s,int wi,int si)
{
    if(si==s.size())
    {
        if(wi==w.size()){return true;}
        for(int i=wi;i<w.size();i++){
            if(w[i]!='*'){return false;}
        }
        return true;
    }
    if(wi==w.size()){return false;}

    char wc=w[wi], sc=s[si];
    bool result=false;
    if(wc=='*')
    {
        for(int i=si;i<=s.size();i++)
        {
            result=result||srch_wildcard(w,s,wi+1,i);
        }
    }
    else if(wc=='?'||wc==sc)
    {
        result=result||srch_wildcard(w,s,wi+1,si+1);
    }
    return result;
}


int main()
{
    int C=0;
    cin>>C;
    vector<string> answer;
    for (int i=0;i<C;i++)
    {
        answer.clear();
        string w;
        int n;
        cin>>w;
        cin>>n;
        for(int j=0;j<n;j++)
        {
            string str;
            cin>>str;
            if(srch_wildcard(w,str,0,0)){answer.push_back(str);}
        }
        sort(answer.begin(),answer.end());
        for(auto v:answer)
        {
            cout<<v<<endl;
        }
    }
    return 0;
}