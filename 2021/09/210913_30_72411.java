/*
 *  2021 kakao blind recruitment
 *  메뉴 리뉴얼
 */

import java.util.*;

class Solution {
    Map<String,Integer> freq;
    int len, max;
    char[] order;
    void countFreq(int idx,String str){
        if(str.length()==len){
            if(freq.containsKey(str)){
                freq.put(str,freq.get(str)+1);
                max=Math.max(max,freq.get(str));
            }else{
                freq.put(str,1);
            }
            return;
        }
        if(idx==order.length) return;
        for(int i=idx+1;i<order.length;i++){
            countFreq(i,str+order[i]);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<String>();
        for(int courseSize:course){
            len=courseSize;
            max=-1;
            freq=new HashMap<String,Integer>();
            for(String order:orders){
                this.order=order.toCharArray();
                Arrays.sort(this.order);
                countFreq(-1,"");
            }
            for(String c:freq.keySet()){
                // System.out.println(c+" "+freq.get(c));
                if(freq.get(c)==max) answerList.add(c);
            }
        }
        String[] answer = answerList.toArray(new String[answerList.size()]);
        Arrays.sort(answer);
        return answer;
    }
}