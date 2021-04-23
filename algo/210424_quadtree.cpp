/*
QUADTREE : https://algospot.com/judge/problem/read/QUADTREE
2021.04.24
문제 분석 : 분할 정복
해결 분석 : 분할된 결과물을 병합할 때 중복되지 않게 주의할 것
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

string flip(string origin){
    if(origin.size()<4)return origin;
    vector<string> parse;
    for(int i=0;i<4;i++){
        string parsed;
        if(origin.front()=='x'){
            parsed="x"+flip(origin.substr(1));
        }else{
            parsed=origin.substr(0,1);
        }
        //cout<<parsed<<" ";
        parse.push_back(parsed);
        if(i<3){
            origin=origin.substr(parsed.size());
        }
    }
    parse.push_back(origin);
    //cout<<": "+parse[0]+parse[1]+parse[2]+parse[3]<<endl;
    return parse[2]+parse[3]+parse[0]+parse[1];
}

int main(){  
    vector<string> answer;
    int C=0;
    cin >> C;
    for(int i=0;i<C;i++){
        string raw_pic;
        cin >> raw_pic;
        answer.push_back(flip(raw_pic));
    }
    for(int i=0;i<C;i++){
        cout<<answer[i]<<endl;
    }
    return 0;
}