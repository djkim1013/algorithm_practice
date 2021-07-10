/*
CLOCKSYNC : https://algospot.com/judge/problem/read/CLOCKSYNC
2021.04.22
문제 분석 : 완전탐색
해결 분석 : 초기값을 매우 큰수 혹은 작은수로 설정해야 할 경우에 주의
*/

#include <iostream>
#include <vector>

using namespace std;

const int switchs[10][5]={
    {0,1,2,-1,-1},
    {3,7,9,11,-1},
    {4,10,14,15,-1},
    {0,4,5,6,7},
    {6,7,8,10,12},
    {0,2,14,15,-1},
    {3,14,15,-1,-1},
    {4,5,7,14,15},
    {1,2,3,4,5},
    {3,4,5,9,13}
};

int min_case;

void count_case(vector<int> clocks,int order,int n_push){
    if(order==10){
	for(int i=0;i<16;i++){
        if((clocks[i]%12)>0)return;
	}
	if(n_push<min_case)min_case=n_push;
	return;
    }
     count_case(clocks,order+1,n_push);
    for(int i=1;i<=3;i++){
	    vector<int> clocks_copy(clocks);
	    for(int j=0;j<5;j++){
	        int n=switchs[order][j];
    	    if(n<0)continue;
	        clocks_copy[n]+=3*i;
    	}
	count_case(clocks_copy,order+1,n_push+i);
  }
  return;
}

int main(){  
    vector<int> answer;
    int C=0;
    cin>>C;
    for(int i=0;i<C;i++){
	    vector<int> clocks;
        for(int j=0;j<16;j++){
            int n;
            cin>>n;
            clocks.push_back(n);
        }
        min_case=0xfff0000;
        count_case(clocks,0,0);
        if (min_case>=0xfff0000){
            answer.push_back(-1);
        }else{
        answer.push_back(min_case);
        }
    }
    for(int i=0;i<C;i++){
    	cout<<answer[i]<<endl;
    }
    return 0;	
}