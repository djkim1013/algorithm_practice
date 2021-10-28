/*
PICNIC: https://algospot.com/judge/problem/read/PICNIC
2021.04.21
문제 분석 : 완전탐색
해결 분석 : 재귀함수 사용 시 반환점 / 비트 연산 시 괄호에 주의할 것
*/

#include <iostream>
#include <vector>

using namespace std;

int total_case = 0;

void count_case(vector<vector<int>> pairs, int order, unsigned list){
    if (order >= pairs.size()){
        if(list==((1<<(order+1))-1)){ 
            total_case++;
        }
        return;
    }
    if ((list & (1 << order)) != 0){
        count_case(pairs, order+1, list);
        return;
    }
    list = list | (1<<order);
    for (int i=0; i<pairs[order].size(); i++){
        int element=pairs[order][i];
        if ((list & (1 << element)) != 0){
            continue;
        }
        count_case(pairs, order+1, list|(1<<element));
    }
    return;
}

int main(){
    int c=0;
    vector<int> answer;
    cin >> c;
    for (int i=0; i<c; i++){
        int n, m;
        cin >> n >> m;
        vector<vector<int>> pairs;
        for (int j=0;j<n-1;j++){
            vector<int> init;
            pairs.push_back(init);
        }
        for (int j=0;j<m;j++){
            int a, b;
            cin >> a >> b;
            if (a>b) {
                int c=a;
                a=b;
                b=c;
            }
            pairs[a].push_back(b);
        }
        total_case=0;
        count_case(pairs,0,0);
        answer.push_back(total_case);
    }
    for (int i=0; i<c; i++){
        cout << answer[i] << endl;
    }
	return 0;
}