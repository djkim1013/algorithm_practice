/*
QUANTIZE : https://algospot.com/judge/problem/read/QUANTIZE
2021.05.
문제 분석 : 동적 계획법
해결 분석 : 단순히 메모이제이션하려고 하면 너무 많음
            수열 나누기 문제로 바꿔서 생각한다.
*/

#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int n, s;
int minput,Minput;

int list_div(vector<int>& input,vector<int>& psum,vector<int>& pdsum,vector<vector<int>>& mem,int idx,int qn){
    if(idx==n) return 0;
    if(qn==s) return 0xfffffff;
    int& ret=mem[idx][qn];
    if(ret!=-1) return ret;
    ret=0xfffffff;
    for(int i=1;idx+i<=n;i++)
    {
        int min_var=psum[idx+i]-psum[idx];
        min_var=int((double)min_var/i+0.5);
        min_var=i*min_var*min_var-2*min_var*(psum[idx+i]-psum[idx]);
        min_var+=pdsum[idx+i]-pdsum[idx];
        /*
        int min_var=psum[idx+i]-psum[idx];
        min_var*=min_var;
        min_var=int((double)min_var/i+0.5);
        min_var=pdsum[idx+i]-pdsum[idx]-min_var;
        */
        ret=min(ret,min_var+list_div(input,psum,pdsum,mem,idx+i,qn+1));
    }
    return ret;
}

int main()
{
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++)
    {
        cin>>n>>s;
        vector<int> input(n);
        vector<int> psum(n),pdsum(n);
        vector<vector<int>> mem(n,vector<int>(s,-1));
        for(int j=0;j<n;j++) cin>>input[j];
        sort(input.begin(),input.end());
        psum[0]=input[0];
        pdsum[0]=input[0]*input[0];
        for(int j=1;j<n;j++)
        {
            psum[j]=psum[j-1]+input[j];
            pdsum[j]=pdsum[j-1]+input[j]*input[j];
        }
        psum.insert(psum.begin(),0);
        pdsum.insert(pdsum.begin(),0);
        cout<<list_div(input,psum,pdsum,mem,0,0)<<endl;
    }
    return 0;
}