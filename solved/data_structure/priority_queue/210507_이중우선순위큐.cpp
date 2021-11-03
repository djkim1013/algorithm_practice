/*
이중우선순위큐 : https://programmers.co.kr/learn/courses/30/lessons/42628
2021.05.07
문제 분류 : 힙
해결 분석 : 정렬로 해결
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    vector<int> arr;
    for(int i=0;i<operations.size();i++)
    {
        if(operations[i][0]=='I')
        {
            arr.push_back(stoi(operations[i].substr(2)));
            sort(arr.begin(),arr.end());
        }
        else if(operations[i][0]=='D')
        {
            if(arr.size()<1)continue;
            int oper=stoi(operations[i].substr(2));
            if(oper>0)
            {
                arr.pop_back();
            }
            else
            {
                arr.erase(arr.begin());
            }
        }
    }
    if(arr.size()<1)
    {
        arr.push_back(0);
    }
    answer.push_back(arr.back());
    answer.push_back(arr.front());
    return answer;
}