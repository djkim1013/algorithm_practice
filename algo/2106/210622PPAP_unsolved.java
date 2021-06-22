//AOJ: PPAP (https://www.algospot.com/judge/problem/read/PPAP)
//2021.06.22(미해결) - 시간초과
//문제 분류: -
//해결 분석: KMP 알고리즘

import java.util.Scanner;

public class Main {
	
	int[] getPi(String str) {
		int len=str.length();
		int[] pi=new int[len];
		int j=0;
		for(int i=1;i<len;i++) {
			while(j>0 && str.charAt(i)!=str.charAt(j)) {
				j=pi[j-1];
			}
			if(str.charAt(i)==str.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		int answer=0;
		String picoStr="pen-pineapple-apple-pen/";
		int picoLen=picoStr.length();
		Scanner sc=new Scanner(System.in);
		
		int l=sc.nextInt()-1;
		int r=sc.nextInt();
		String p=sc.next();
		int pLen=p.length();

		int[] pi=m.getPi(p);
		
		int j=0;
		int answerSkip=0;
		for(int i=l;i<r;i++){
//			if(i>=l+pLen && i+picoLen<r) {
//				answerSkip+=answer;
//				i+=picoLen-1;
//				System.out.println(i+" "+answer);
//				continue;
//			}
			int cur=i%picoLen;
			while(j>0 && picoStr.charAt(cur)!=p.charAt(j)) {
				j=pi[j-1];
			}
			if(picoStr.charAt(cur)==p.charAt(j)) {
				if(j==pLen-1) {
					answer++;
					j=pi[j];
					//System.out.println(i+" "+cur+answer);
				}else {
					j++;
				}
			}
		};
		answer+=answerSkip;
		System.out.print(answer);
	}

}
