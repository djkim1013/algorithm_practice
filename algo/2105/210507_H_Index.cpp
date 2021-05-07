/*
H-Index : https://programmers.co.kr/learn/courses/30/lessons/42747
2021.05.07
문제 분석 : 정렬
해결 분석 : 뭐든지 재귀로 해결하려고 하지 말 것
*/

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(),citations.end(),greater<>());
    for(int i=0;i<citations.size();i++)
    {
        if(citations[i]<i+1)
            return i;
    }
    
    return citations.size();
}