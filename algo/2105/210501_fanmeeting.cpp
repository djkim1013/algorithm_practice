/*
FANMEETING : https://algospot.com/judge/problem/read/FANMEETING
2021.05.03
문제 분석 : 분할정복(카라츠바 알고리즘)
해결 분석 : 매우 큰 수를 곱할 때 시간복잡도를 변경할 때 필요하다. 단 곱샘을 구하는 프로그램이 아니므로 자리올림은 생략함에 주의.
            런타임오류 발생 - 벡터 스텍오버플로우에 주의
*/

#include <vector>
#include <iostream>

using namespace std;

void addTo(vector<int>& a,vector<int>& b,int n){
    a.resize(max(a.size(),b.size()+n));
    for(int i=0;i<b.size();i++){
        a[i+n]+=b[i];
    }
    return;
}

void subFrom(vector<int>& a,vector<int>& b){
    a.resize(max(a.size(),b.size())+1);
    for(int i=0;i<b.size();i++){
        a[i]-=b[i];
    }
    return;
}

vector<int> multiply(vector<int>& a,vector<int>& b){
    vector<int> result(a.size()+b.size()+1);
    for(int i=0;i<a.size();i++)
        for(int j=0;j<b.size();j++){
            result[i+j]+=a[i]*b[j];
    }
    /*
    result.push_back(0);
    for(int i=0;i+1<result.size();i++){
        if(result[i]<0){
            int borrow=(abs(result[i]+9)/10);
            result[i+1]-=borrow;
            result[i]+=borrow*10;
        }else{
            result[i+1]+=result[i]/10;
            result[i]%=10;
        }
    }
    while(result.size()>1&&result.back()==0)result.pop_back();
    //*/
    return result;
}

vector<int> karatsuba(vector<int>& a,vector<int>& b){
    int a_len=a.size(), b_len=b.size();
    if(a_len<b_len)return karatsuba(b,a);
    int half=a_len/2;
    if(a_len==0||b_len==0)return vector<int>(a_len,0);
    if(a_len<50)return multiply(a,b);
    vector<int> a0(a.begin(),a.begin()+half);
    vector<int> a1(a.begin()+half,a.end());
    vector<int> b0(b.begin(),b.begin()+min(half,b_len));
    vector<int> b1(b.begin()+min(half,b_len),b.end());
    vector<int> z0=karatsuba(a0,b0);
    vector<int> z2=karatsuba(a1,b1);
    addTo(a0,a1,0);
    addTo(b0,b1,0);
    vector<int> z1=karatsuba(a0,b0);
    subFrom(z1,z0);
    subFrom(z1,z2);
    addTo(z0,z1,half);
    addTo(z0,z2,half+half);
    return z0;
}

int main(){
    int C=0;
    cin>>C;
    for (int i=0;i<C;i++){
        int answer=0;
        string members;
        string fans;
        int all_hug=0;
        cin>>members>>fans;
        vector<int> members_M(members.size()), fans_M(fans.size());
        for(int j=0;j<members.size();j++)
            members_M[j]=(members[j]=='M');
        for(int j=0;j<fans.size();j++)
            fans_M[fans.size()-j-1]=(fans[j]=='M');
        vector<int> shake(karatsuba(fans_M,members_M));
        for(int j=members.size()-1;j<fans.size();j++)
            if(!shake[j])answer++;
        cout<<answer<<endl;
    }
    return 0;
}