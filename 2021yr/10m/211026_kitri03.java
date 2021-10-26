//코딩테스트 광탈방지 - 03 이분탐색
//2021.10.26
//category: 이분탐색
//review:

import java.util.stream.*;

class Solution {
    public int solution(int[] budgets, int M) {
        int answer=0;
        int min=1;
        int max=IntStream.of(budgets).max().orElse(0);
                
        while(min<=max){
            int mid=(min+max)/2;
            long sum=IntStream.of(budgets)
                .map(b->Math.min(b,mid))
                .sum();
            if(sum>M) max=mid-1;
            else{
                min=mid+1;
                answer=mid;
            }
        }
        return answer;
    }
}