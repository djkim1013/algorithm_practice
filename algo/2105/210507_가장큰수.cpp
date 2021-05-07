/*
가장 큰 수 : https://programmers.co.kr/learn/courses/30/lessons/42746
2021.05.07
문제 분석 : 정렬
해결 분석 : 우위 판별식이 문제를 정확히 반영하도록 신경쓸 것
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(string a,string b)
{
    return a+b>b+a;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> ntos;
    for(auto i:numbers)
        ntos.push_back(to_string(i));
    if(numbers.size()<=1)return ntos[0];
    sort(ntos.begin(),ntos.end(),comp);
    if(ntos.front()=="0")return "0";
    for(auto s:ntos)
        answer+=s;
    return answer;
}