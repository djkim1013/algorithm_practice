//코딩테스트 광탈방지 - 02 정렬
//2021.10.26
//category: 정렬
//review:

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings=new String[numbers.length];
        for(int i=0;i<numbers.length;i++) strings[i]=numbers[i]+"";
        Arrays.sort(strings,new Comparator<String>(){
           @Override
            public int compare(String a,String b){
                return (b+a).compareTo(a+b);
            }
        });
        if(strings[0].charAt(0)=='0') return "0";
        for(String str:strings) answer+=str;
        return answer;
    }
}