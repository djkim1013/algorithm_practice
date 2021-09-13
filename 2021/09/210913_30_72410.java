/*
 *  2021 kakao blind recruitment
 *  신규아이디 추천
 */

import java.util.*;

class Solution {
    final String charSet="abcdefghijklmnopqrstuvwxyz-_.1234567890";
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder(new_id);
        for(int i=0;i<answer.length();i++){
            if(charSet.indexOf(answer.charAt(i))<0){
                if(Character.isUpperCase(answer.charAt(i)))
                    answer.setCharAt(i,Character.toLowerCase(answer.charAt(i)));
                else{
                    answer.delete(i,i+1);
                    i--;
                }
            }
        }
        for(int i=0;i+1<answer.length();i++){
            if(answer.charAt(i)==answer.charAt(i+1)&&answer.charAt(i)=='.'){
                answer=answer.delete(i,i+1);
                i--;
            }
        }
        while(answer.length()>0){
            if(answer.charAt(0)=='.') answer.delete(0,1);
            else break;
        }
        while(answer.length()>0){
            if(answer.charAt(answer.length()-1)=='.') 
                answer.delete(answer.length()-1,answer.length());
            else break;
        }
        if(answer.length()==0) answer=new StringBuilder("a");
        if(answer.length()>15){
            if(answer.charAt(14)=='.') answer.delete(14,answer.length());
            else answer=answer.delete(15,answer.length());
        }
        if(answer.length()<3){
            char c=answer.charAt(answer.length()-1);
            while(answer.length()<3){
                answer.append(c);
            }
        }
        return answer.toString();
    }
}