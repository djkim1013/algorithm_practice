/*
 *  2021 kakao blind recruitment
 *  순위 검색
 */

import java.util.*;

class Solution {
    Map<String,ArrayList<Integer>> map=new HashMap<String,ArrayList<Integer>>();
    void dfs(String[] infoSplit,String key,int score,int depth){
        if(depth==4){
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<Integer>());
            }
            map.get(key).add(score);
            return;
        }
        dfs(infoSplit,key+infoSplit[depth],score,depth+1);
        dfs(infoSplit,key+"-",score,depth+1);
    }
    void setMap(String info){
        String[] infoSplit=info.split(" ");
        int score=Integer.parseInt(info.substring(info.lastIndexOf(" ")+1));
        dfs(infoSplit,"",score,0);
    }
    int getCut(String key,int cut){
        if(!map.containsKey(key)) return 0;
        ArrayList<Integer> scoreList=map.get(key);
        int head=0;
        int tail=scoreList.size()-1;
        while(head<=tail){
            int mid=(head+tail)/2;
            if(scoreList.get(mid)<cut){
                head=mid+1;
            }else{
                tail=mid-1;
            }
        }
        return scoreList.size()-head;
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer=new int[query.length];
        for(int i=0;i<info.length;i++) setMap(info[i]);
        for(String key:map.keySet())
            Collections.sort(map.get(key));
        for(int i=0;i<query.length;i++){
            String q=query[i].replaceAll("and|\\s|\\d","");
            int cut=Integer.parseInt(query[i].substring(query[i].lastIndexOf(" ")+1));
            answer[i]=getCut(q,cut);
        }
        return answer;
    }
}