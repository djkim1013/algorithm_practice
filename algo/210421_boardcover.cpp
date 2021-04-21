/*
BOARDCOVER : https://algospot.com/judge/problem/read/BOARDCOVER
2021.04.21
문제 분석 : 완전탐색
해결 분석 : 중복 계산이나 누락을 피하기 위해서는 ㄴ자 블록의 기준점은 가장 윗쪽의 왼쪽 되어야만 한다.
*/

#include <iostream>
#include <vector>

using namespace std;

int H, W;
int total_case;

void count_case(vector<vector<int>> board,int order){
    if ((order/W) >= (H-1)){
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if (board[i][j]==0) return;
            }
        }
        total_case++;
        return;
    }
    int h=order/W, w=order%W;
    order++;
    if(board[h][w]==1){
        count_case(board,order);
        return;
    }
    if(w<(W-1)){
        if(board[h][w+1]==0){
            if((board[h+1][w]==0)){
                vector<vector<int>> board_copy(board);
                board_copy[h][w]=1;
                board_copy[h][w+1]=1;
                board_copy[h+1][w]=1;
                count_case(board_copy,order);
            }
            if((board[h+1][w+1]==0)){
                vector<vector<int>> board_copy(board);
                board_copy[h][w]=1;
                board_copy[h][w+1]=1;
                board_copy[h+1][w+1]=1;            
                count_case(board_copy,order);
                
            }
        }
        if(board[h+1][w]==0){
            if(board[h+1][w+1]==0){
                vector<vector<int>> board_copy(board);
                board_copy[h][w]=1;
                board_copy[h+1][w]=1;
                board_copy[h+1][w+1]=1;                
                count_case(board_copy,order);
            }
        }
    }
    if(w>0){
        if(board[h+1][w]==0){
            if(board[h+1][w-1]==0){
                vector<vector<int>> board_copy(board);
                board_copy[h][w]=1;
                board_copy[h+1][w]=1;
                board_copy[h+1][w-1]=1;
                count_case(board_copy,order);
            }
        }
    }
    return;
}

int main(){
    int c = 0 ;
    vector<int> answer;
    cin >> c;
    for(int i=0; i<c; i++){
        H=0; W=0;
        cin >> H >> W;
        vector<vector<int>> board;
        for(int j=0; j<H; j++){
            vector<int> board_init(W);
            board.push_back(board_init);
            for(int k=0; k<W; k++){
                char blank;
                cin >> blank;
                if (blank == '#'){
                    board[j][k]=1;
                }else if (blank == '.'){
                    board[j][k]=0;
                }
            }
        }
        total_case=0;
        count_case(board,0);
        answer.push_back(total_case);
    }
    for(int i=0; i<c; i++){
        cout << answer[i] << endl;
    }
	return 0;
}