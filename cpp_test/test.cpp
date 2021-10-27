//BOJ: 1655
//date: 2021.10.27
//category: priority queue
//review:

#include <iostream>
#include <queue>
#include <functional>

using namespace std;

int main(){
	int n;
	cin>>n;
	priority_queue<int> left;
	priority_queue<int,vector<int>,less<int>> right;
	int mid=0;
	while(n-->0){
		int input;
		cin>>input;
		if(right.size()>left.size()) right.push(input);
		else left.push(input);
		while(left.top()>right.top()){
			int temp=left.top();
			right.push(temp);
			left.pop();
			temp=right.top();
			left.push(temp);
			right.pop();
		}
		cout<<left.top()<<endl;
	}
}