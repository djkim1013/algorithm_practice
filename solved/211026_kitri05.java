//코딩테스트 광탈방지 - 05 해쉬
//2021.10.26
//category: 
//review:

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
            .map(c->c[1])
            .distinct()
            .map(type->(int)Arrays.stream(clothes).filter(c->c[1].equals(type)).count()+1)
            .reduce(1,(c,n)->c*n)-1;
    }
}