//코딩테스트 광탈방지 - 01 그리디
//2021.10.25
//category: 그리디
//review:

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cur = 1;
        int next=0;
        while(cur<=n){
            if(next<stations.length&&cur>=stations[next]-w){
                cur=stations[next]+w+1;
                next++;
            }else{
                answer++;
                cur+=2*w+1;
            }
        }
        return answer;
    }
}