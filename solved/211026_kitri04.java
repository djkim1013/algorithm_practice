//코딩테스트 광탈방지 - 04 시뮬레이션
//2021.10.26
//category: 
//review:

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer=0;
        Arrays.sort(A);
        Arrays.sort(B);
        int bi=B.length-1;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]<B[bi]){
                bi--;
                answer++;
            }
        }
        return answer;
    }
}