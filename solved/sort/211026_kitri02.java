//코딩테스트 광탈방지 - 02 정렬
//2021.10.26
//category: 정렬
//review:

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers)
            .mapToObj(String::valueOf)
            .sorted((a,b)->(b+a).compareTo(a+b))
            .collect(Collectors.joining());
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}