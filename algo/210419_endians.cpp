/*
ENDIANS: https://algospot.com/judge/problem/read/ENDIANS
2021.04.19 (복습)
문제 분석 : 비트 연산, 입력값에 따른 출력 횟수 제어
해결 분석 : 자료형이 int가 아닌 unsigned여야 한다는 것에 주의
*/

#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    vector<unsigned> answer;
    cin >> n;
    for ( int i = 0; i < n; i++ ){
    	unsigned input = 0, output = 0;
    	cin >> input ;
    	output += (input & 0xff000000) >> 24 ;
    	output += (input & 0x00ff0000) >> 8 ;
    	output += (input & 0x0000ff00) << 8 ;
    	output += (input & 0x000000ff) << 24 ;
    	answer.push_back(output);
    }
	for ( int i=0; i<n; i++){
	    cout << answer[i] << endl;
	}
	return 0;	
}