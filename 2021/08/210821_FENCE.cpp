//AOJ: FENCE
//2021.08.21
//문제 분류: 분할정복
//해결 분석:

#include <iostream>

using namespace std;

int main(){
  int C=0;
  int fence[20000];
  cin>>C;
  for (int c=0;c<C;c++){
    int answer=-1;
	int n=0;
	cin>>n;  
	for(int i=0;i<n;i++){
	  cin>>fence[i];
	}
	for(int i=0;i<n;i++){
	  int height=fence[i];
	  int size=height;
	  for(int j=i-1;j>=0;j--){
		if(fence[j]<height)break;
		size+=height;
	  }
	  for(int j=i+1;j<n;j++){
		if(fence[j]<height)break;
		size+=height;
	  }
	  if(answer<size)answer=size;
	}
    cout<<answer<<endl;
  }
  return 0;
}