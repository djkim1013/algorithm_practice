//AOJ: PPAP (https://www.algospot.com/judge/problem/read/PPAP)
//2021.06.22
//문제 분류: -
//해결 분석: KMP 알고리즘
//		자바로는 1000ms 제한시간이 초과되어 cpp코드로 작성하여 통과

//*
import java.util.Scanner;

public class Main {
	
	static int[] pi;
	
	static void getPi(String str) {
		int len=str.length();
		int j=0;
		for(int i=1;i<len;i++) {
			while(j>0 && str.charAt(i)!=str.charAt(j)) {
				j=pi[j-1];
			}
			if(str.charAt(i)==str.charAt(j)) {
				pi[i]=++j;
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		int answer=0;
		String picoStr="pen-pineapple-apple-pen/";
		int picoLen=picoStr.length();
		Scanner sc=new Scanner(System.in);
		
		int l=sc.nextInt()-1;
		int r=sc.nextInt();
		String p=sc.next();
		int pLen=p.length();

		pi=new int[pLen];
		getPi(p);
		
		int j=0;
		for(int i=l;i<r;i++){
			int cur=i%picoLen;
			if(i>l+pLen && i+picoLen<r && cur==0) {
				int answerSkip=0;
				for(;cur<picoLen;cur++) {
					while(j>0 && picoStr.charAt(cur)!=p.charAt(j)) {
						j=pi[j-1];
					}
					if(picoStr.charAt(cur)==p.charAt(j)) {
						if(j==pLen-1) {
							answerSkip++;
							j=pi[j];
						}else {
							j++;
						}
					}
				}
				while(i+picoLen<r) {
					i+=picoLen;
					answer+=answerSkip;
					//System.out.println("skip"+i+" "+answer);
				}
				i--;
				continue;
			}
			while(j>0 && picoStr.charAt(cur)!=p.charAt(j)) {
				j=pi[j-1];
			}
			if(picoStr.charAt(cur)==p.charAt(j)) {
				if(j==pLen-1) {
					answer++;
					j=pi[j];
					//System.out.println(i+" "+answer);
				}else {
					j++;
				}
			}
		};
		System.out.print(answer);
	}

}

/*/
#include <iostream>
#include <string>

using namespace std;

int pi[10001];
	
void getPi(string str) {
	int len=str.length();
	int j=0;
	for(int i=1;i<len;i++) {
		while(j>0 && str[i]!=str[j]) {
			j=pi[j-1];
		}
		if(str[i]==str[j]) {
			pi[i]=++j;
		}
	}
	return;
}

int main() {
	int answer=0;
	string picoStr="pen-pineapple-apple-pen/";
	int picoLen=picoStr.length();
	
	int l,r;
	string p;
	
	cin>>l>>r>>p;
	l--;
	
	int pLen=p.length();

	getPi(p);
	
	int j=0;
	for(int i=l;i<r;i++){
		int cur=i%picoLen;
		if(i>l+pLen && i+picoLen<r && cur==0) {
			int answerSkip=0;
			for(;cur<picoLen;cur++) {
				while(j>0 && picoStr[cur]!=p[j]) {
					j=pi[j-1];
				}
				if(picoStr[cur]==p[j]) {
					if(j==pLen-1) {
						answerSkip++;
						j=pi[j];
					}else {
						j++;
					}
				}
			}
			while(i+picoLen<r) {
				i+=picoLen;
				answer+=answerSkip;
			}
			i--;
			continue;
		}
		while(j>0 && picoStr[cur]!=p[j]) {
			j=pi[j-1];
		}
		if(picoStr[cur]==p[j]) {
			if(j==pLen-1) {
				answer++;
				j=pi[j];
			}else {
				j++;
			}
		}
	};
	cout<<answer<<endl;
}
*/
