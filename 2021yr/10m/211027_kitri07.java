//코딩테스트 광탈방지 - 07 올바른 괄호의 갯수
//2021.10.27
//category: DFS
//review:

import java.util.Stack;

class Solution {
    public int solution(int n) {
        Stack<int[]> stk=new Stack<>();
        stk.add(new int[]{1,0});
        int answer=0;
        while(!stk.isEmpty()){
            int[] cur=stk.peek();
            stk.pop();
            int open=cur[0], close=cur[1];
            if(open==n&&close==n){
                answer++;
                continue;
            }
            if(open<n) stk.add(new int[]{open+1,close});
            if(open>close) stk.add(new int[]{open,close+1});
        }
        return answer;
    }
}