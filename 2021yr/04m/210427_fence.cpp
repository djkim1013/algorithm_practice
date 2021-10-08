/*
FENCE : https://algospot.com/judge/problem/read/FENCE
2021.04.27
문제 분석 : 분할 정복
해결 분석 : 채점에서는 정답이었지만, 분할설계를 했다고 보긴 어렵다.
            교재 15.11절, 19.3절의 해법과 비교해 볼 것.
*/

#include <vector>
#include <iostream>

using namespace std;

int main(){
    int C=0;
    cin>>C;
    vector<int> answer(C,-1);
    for (int i=0;i<C;i++){
        vector<int> fence;
        int fence_size=0;
        cin>>fence_size;
        for(int j=0;j<fence_size;j++){
            fence.push_back(0);
            cin>>fence.back();
        }
        for(int j=0;j<fence_size;j++){
            int height=fence[j];
            int size=height;
            for(int k=j-1;k>=0;k--){
                if(fence[k]<height)break;
                size+=height;
            }
            for(int k=j+1;k<fence_size;k++){
                if(fence[k]<height)break;
                size+=height;
            }
            if(answer[i]<size)answer[i]=size;
        }
    }
    for(auto v:answer){
        cout<<v<<endl;
    }
    return 0;
}