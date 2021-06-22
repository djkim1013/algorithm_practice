//baekjoon : 1065 (https://www.acmicpc.net/problem/1065)
//21.06.22
//문제 분류: 브루트포스(완전탐색)
//해결 분석: 중복 집계하지 않도록 boolean 배열 설정

import java.util.Scanner;

public class Main{
    
	boolean[] mem=new boolean[1001];
	int n;
    
    int countHan(int degree, int pre, int whole){
    	if(whole > n || pre < 0 || pre >= 10)
            return 0;
    	int count=0;
    	if(!mem[whole]) {
    		count++;
    		mem[whole]=true;
    	}
    	count += countHan(degree,pre+degree,whole*10+pre+degree);
//    	System.out.println(whole);
    	return count;
    }
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        
        int answer=0;
        m.n = sc.nextInt();
        
        for(int i=1; i<=9; i++) {
        	for(int j=-9;j<=9;j++)
        		answer+=m.countHan(j,i,i);
        }
        
        System.out.println(answer);
    }
}
