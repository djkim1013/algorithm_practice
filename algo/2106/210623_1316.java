//baekjoon : 1316 (https://www.acmicpc.net/problem/1316)
//21.06.23
//문제 분류: 구현, 문자열
//해결 분석: 매개변수 범위 주의

import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int r = sc.nextInt();
        
        String[] strList = new String[100];
        for(int i = 0; i < r; i++) {
        	strList[i] = sc.next();
        }
        
        int answer = 0;
        for(int i = 0; i < r; i++) {
        	String str = strList[i];
        	int len = str.length();
        	int j = -1;
        	boolean flag=true;
        	while(++j < len - 1 && flag) { 
        		if(str.charAt(j) != str.charAt(j + 1)) {
        			int cur = j;
        			char target = str.charAt(j);
        			while(++cur < len) {
        				if(str.charAt(cur) == target) {
        					flag = false;
        					break;
        				}
        			}
        		}
        	}
    		if(flag) answer++;
        }
        System.out.println(answer);
        
    }
}
