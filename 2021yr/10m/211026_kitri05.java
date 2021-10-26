//코딩테스트 광탈방지 - 05 해쉬
//2021.10.26
//category: 
//review:

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> kinds=new HashMap<String,Integer>();
        for(String[] c:clothes){
            if(!kinds.containsKey(c[1])) kinds.put(c[1],0);
            kinds.put(c[1],kinds.get(c[1])+1);
        }
        for(String kind:kinds.keySet()){
            answer*=kinds.get(kind)+1;
        }
        return answer-1;
    }
}