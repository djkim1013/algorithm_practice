/*
 *  2021 kakao blind recruitment
 *  광고 삽입
 */

import java.util.*;

class Solution {
    int timeStrToSec(String log){
        int sec=3600*Integer.parseInt(log.substring(0,2));
        sec+=60*Integer.parseInt(log.substring(3,5));
        sec+=Integer.parseInt(log.substring(6,8));
        return sec;
    }
    
    String timeSecToStr(int sec){
        StringBuilder str=new StringBuilder();
        if(sec/3600<10) str.append("0");
        str.append(Integer.toString(sec/3600)+":");
        sec%=3600;
        if(sec/60<10) str.append("0");
        str.append(Integer.toString(sec/60)+":");
        sec%=60;
        if(sec<10) str.append("0");
        str.append(Integer.toString(sec));
        return str.toString();
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer=0;
        int answer_sec=0, sum=0;
        int end_sec=timeStrToSec(play_time);
        int adv_sec=timeStrToSec(adv_time);
        int[] timeTable=new int[end_sec+1];
        for(int i=0;i<logs.length;i++){
            String log=logs[i];
            timeTable[timeStrToSec(log.substring(0,8))]++;
            timeTable[timeStrToSec(log.substring(9,17))]--;
        }
        for(int i=1;i<end_sec;i++) timeTable[i]+=timeTable[i-1];
        for(int i=0;i<adv_sec;i++) sum+=timeTable[i];
        answer_sec=sum;
        for(int i=1;i<=end_sec-adv_sec;i++){
            sum+=timeTable[i+adv_sec-1]-timeTable[i-1];
            if(sum>answer_sec){
                answer_sec=sum;
                answer=i;
            }
        }
        return timeSecToStr(answer);
    }
}