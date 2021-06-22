//AOJ: PPAP (https://www.algospot.com/judge/problem/read/PPAP)
//2021.06.
//문제 분류: -
//해결 분석: KMP 알고리즘

import java.util.Scanner;

public class Main {
	
	static int[] getPi(String str) {
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
		Scanner sc=new Scanner(System.in);
		int answer=0;
		String picoStr="pen-pineapple-apple-pen/";
		int picoLen=picoStr.length();
		
		int l=sc.nextInt()-1;
		int r=sc.nextInt();
		String p=sc.next();
		int pLen=p.length();

		int[] pi=getPi(p);
		
		int j=0;
		int answerSkip=0;
		for(int i=l;i<r;i++){
			if(i>=l+pLen && i+picoLen<r) {
				answerSkip+=answer;
				i+=picoLen-1;
				System.out.println(i+" "+answer);
				continue;
			}
			int cur=i%picoLen;
			while(j>0 && picoStr.charAt(cur)!=p.charAt(j)) {
				j=pi[j-1];
			}
			if(picoStr.charAt(cur)==p.charAt(j)) {
				if(j==pLen-1) {
					answer++;
					j=pi[j];
					System.out.println(i+" "+cur+answer);
				}else {
					j++;
				}
			}
		};
		answer+=answerSkip;
		System.out.print(answer);
	}

}

/*
#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> getPi(string& str) {
	vector<int> pi(str.size());
	int j=0;
	for(int i=1;i<str.size();i++) {
		while(j>0 && str[i]!=str[j]) {
			j=pi[j-1];
		}
		if(str[i]==str[j]) {
			pi[i]=++j;
		}
	}
	return pi;
}


int main()
{
	int answer=0;
	string picoStr="pen-pineapple-apple-pen/";
	int picoLen=picoStr.length();
	
	int l,r;
	string p;
	cin>>l>>r>>p;
	int pLen=p.length();

	vector<int> pi=getPi(p);
	
	int j=0;
	for(int i=l;i<r;i++){
		int cur=i%picoLen;
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