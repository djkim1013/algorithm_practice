/*
DRAWRECT: https://algospot.com/judge/problem/read/DRAWRECT
2021.04.19
문제 분석 : 세 좌표에서 각 하나씩만 있는 점을 찾는다.
해결 분석 : if문이 가장 깔끔한 방법인지 의문
*/

#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    vector<int> answer;
    cin >> n ;
    for ( int i = 0; i < n; i++ ){
    	int coord[6];
        int coord_x,coord_y;
        for (int j=0;j<6;j+=2){
            cin >> coord[j] >> coord[j+1] ;
        }
        if (coord[0]==coord[2]){
            answer.push_back(coord[4]);
        }else if(coord[0]!=coord[4]){
            answer.push_back(coord[0]);
        }else{
            answer.push_back(coord[2]);
        }
        if (coord[1]==coord[3]){
            answer.push_back(coord[5]);
        }else if(coord[1]!=coord[5]){
            answer.push_back(coord[1]);
        }else{
            answer.push_back(coord[3]);
        }
    }
    
    for ( int i = 0; i < n; i++ ){
        cout << answer[i*2] <<" "<< answer[i*2+1] <<endl;
    }

	return 0;
}