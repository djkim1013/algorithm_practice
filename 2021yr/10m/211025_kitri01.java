//코딩테스트 광탈방지 - 01 그리디
//2021.10.22
//category: 그리디
//review:

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 1;
        for(int i:stations){
            int d=i-w-prev;
            //이전 기지국 오른쪽 끝과 다음 기지국 왼쪽끝 사이의 거리가 1이상이면 도달거리로 나눈다.
            if(d>0) answer+=(d+2*w)/(2*w+1);
            prev=i+w+1;
        }
        //마지막 기지국 오른쪽 끝에서 마지막 아파트 사이의 거리가 1이상이면 도달거리로 나눈다.
        if(n+1-prev>0) answer+=(n+1-prev+2*w)/(2*w+1);
        return answer;
    }
}