/*
구명보트 : https://programmers.co.kr/learn/courses/30/lessons/42885
2021.05.07
문제 분석 : 탐욕법
해결 분석 : 
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(),people.end());
    int b=0,e=people.size()-1;
    while(e>=b)
    {
        int i;
        int w=people[e];
        for(i=0;b+i<e;i++)
        {
            if(w+people[b+i]>limit)break;
            w+=people[b+i];
        }
        answer++;
        b+=i;
        e--;
    }
    return answer;
}