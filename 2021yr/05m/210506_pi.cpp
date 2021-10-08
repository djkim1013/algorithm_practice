/*
PI : https://algospot.com/judge/problem/read/PI
2021.05.06
문제 분석 : 동적 계획법
해결 분석 : 입력값이 문자열일 때 숫자로 입력 받으면 오류가 발생한다.
*/

#include <vector>
#include <iostream>
#include <string>

using namespace std;

int n=0;

int check_level(vector<int>& input,int b,int e){
    bool check=true;
    bool iso=true;
    for(int i=b;i<e-1;i++)
    {
        if(input[i]!=input[i+1])
        {
            check=false;
            break;
        }
    }
    if(check) return 1;
    check=true;
    int grade=input[b+1]-input[b];
    for(int i=b+1;i<e-1;i++)
    {
        if(input[i]+grade!=input[i+1])
        {
            check=false;
            iso=false;
            break;
        }
    }
    if(check&&(grade==1||grade==-1)) return 2;
    check=true;
    for(int i=b;i<e-2;i++)
    {
        if(input[i]!=input[i+2])
        {
            check=false;
            break;
        }
    }
    if(check) return 4;
    if(iso) return 5;
    return 10;
}

int find_level(vector<int>& input,vector<int>& mem,int idx){
    if(idx==n)return 0;
    int& ret=mem[idx];
    if(ret!=-1)return ret;
    ret=0xfffffff;
    for(int i=idx+3;i<=idx+5;i++)
    {
        if(i<=n)
            ret=min(ret,find_level(input,mem,i)+check_level(input,idx,i));
    }
    return ret;
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        string input_s;
        cin>>input_s;
        n=input_s.size();
        vector<int> input;
        vector<int> mem(n,-1);
        for(int i=0;i<n;i++)
            input.insert(input.begin(),stoi(input_s.substr(i,1)));
        cout<<find_level(input,mem,0)<<endl;
    }
    return 0;
}