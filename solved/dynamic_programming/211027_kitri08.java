//코딩테스트 광탈방지 - 08 정수삼각형 직접 풀어보기
//2021.10.27
//category: 동적계획법
//review:

class Solution {
    
    public int solution(int[][] triangle) {
        for(int i=triangle.length-2;i>=0;i--){
            for(int j=0;j<=i;j++)
                triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
        }
        return triangle[0][0];
    }
}