//코딩테스트 광탈방지 - 03 이분탐색
//2021.10.26
//category: 이분탐색
//review:

class Solution {
    public int solution(int[] budgets, int M) {
        int answer=0;
        int min=1;
        int max=0;
        for(int b:budgets) max=Math.max(b,max);
        
        while(min<=max){
            int mid=(min+max)/2;
            long sum=0;
            for(int b:budgets){
                sum+=Math.min(b,mid);
            }
            if(sum>M) max=mid-1;
            else{
                min=mid+1;
                answer=mid;
            }
        }
        return answer;
    }
}