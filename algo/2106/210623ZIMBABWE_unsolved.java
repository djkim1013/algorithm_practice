//AOJ: ZIMBABWE (https://www.algospot.com/judge/problem/read/ZIMBABWE)
//2021.06.23
//문제 분류: 동적계획법
//해결 분석: 

import java.util.*;

public class Main {
	
	static final int mod = 1000000007;
	static String e, plates;
	static int n;
	
	static int generate(String price, int taken) {
		int len=price.length(); 
		if(len==n) {
			System.out.println(price);
			if(price.compareTo(e)>0) {
				return 1;
			}
			return 0;
		}
		int answer=0;
		for(int i=0;i<len;i++) {
			if(((taken&(1<<i))==0)&&
					(i==0||e.charAt(i)!=e.charAt(i-1)||(taken&(1<<(i-1)))!=0)) {
				int takenCp=taken|(1<<i);
				System.out.println(takenCp);
				answer+=generate(price+e.charAt(i),takenCp);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		for(int i=0;i<c;i++) {
			e=sc.next();
			n=e.length();	
			int m=sc.nextInt();

			char[] eSort=e.toCharArray();
			Arrays.sort(eSort);
			plates=String.valueOf(eSort);
			
			int taken=0;
			
			System.out.println(generate("",taken));
		}
		
	}

}
