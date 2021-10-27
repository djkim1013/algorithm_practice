//코딩테스트 광탈방지 - 08 정수삼각형 직접 풀어보기
//2021.10.27
//category: 동적계획법
//review:

import java.util.Arrays;

class Solution {
    int n;
    int[][] triangle,cache;
    
    int maxSum(int row,int col){
        if(row==n||col==n) return 0;
        if(cache[row][col]!=-1) return cache[row][col];
        int ret=Math.max(maxSum(row+1,col),maxSum(row+1,col+1));
        return cache[row][col]=triangle[row][col]+ret;
    }
    
    public int solution(int[][] triangle) {
        this.triangle=triangle;
        n=triangle.length;
        cache=new int[n][];
        for(int i=0;i<n;i++){
            cache[i]=new int[i+1];
            Arrays.fill(cache[i],-1);
        }
        return maxSum(0,0);
    }
}