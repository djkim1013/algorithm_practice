/*
 *  2021 kakao blind recruitment
 *  매출 최소화
 */

import java.util.*;

class Solution {
    int[] sales;
    int[][] cache;
    Map<Integer,ArrayList<Integer>> links=new HashMap<Integer,ArrayList<Integer>>();
    
    int sum(int idx,int attend){
        if(idx==0) return Math.min(sum(1,1),sum(1,0));
        int ret=cache[idx][attend];
        if(ret>-1) return ret;
        if(!links.containsKey(idx))
            return cache[idx][attend]=(attend==1?sales[idx-1]:0);
        ret=0;
        int team=0;
        int min1=0xfffffff;
        for(int i:links.get(idx)){
            int sum0=sum(i,0);
            int sum1=sum(i,1);
            if(sum0>=sum1){
                team++;
                ret+=sum1;
            }else{
                min1=Math.min(sum1-sum0,min1);
                ret+=sum0;
            }
        }
        if(team+attend==0) ret+=min1;
        if(attend==1) ret+=sales[idx-1];
        return cache[idx][attend]=ret;
    }
    
    public int solution(int[] sales, int[][] links) {
        this.sales=sales;
        cache=new int[sales.length+1][2];
        for(int[] c:cache) c[0]=c[1]=-1;
        for(int i=0;i<links.length;i++){
            int key=links[i][0];
            int value=links[i][1];
            if(!this.links.containsKey(key)){
                this.links.put(key,new ArrayList<Integer>());
            }
            this.links.get(key).add(value);
        }
        return sum(0,0);
    }
}