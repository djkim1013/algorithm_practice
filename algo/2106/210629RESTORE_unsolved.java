//AOJ: RESTORE
//2021.06.
//문제 분류: 
//해결 분석: 

// import java.io.*;
import java.util.*;

public class Main {
	static final int BIGNUM = 0xfffffff;
	static StringBuilder[] arr = new StringBuilder[15];
	static int[] cache = new int[16];
	static int n;
	
	int findShortest(int idx, int used, int len){
		if(idx==n){
			if(len<cache[idx]){
				return len;
			}
			return cache[idx];
		}
		int ret = cache[idx];
		if(ret!=-1)return cache[idx];
		for(int i=0; i<n; i++){
			if((used&(1<<i)) != 0)continue;
			StringBuilder strFront = new StringBuilder();
			for(int j=0;j<n;j++){
				if((used&(1<<j)) != 0) continue;
				StringBuilder strBack = new StringBuilder();
				int front = strFront.length()-1;
				int back = 0;
				StringBuild str
				while(front>0 && back<strBack.length()){
				}

			}
			
		}
		ret = len;

		cache[idx] = ret;
		return ret;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int i=0;i<c;i++){
			n = sc.nextInt();
			Arrays.fill(cache,-1);
			Arrays.fill(arr,null);
			for(int j=0;j<n;j++){
				String str = sc.next();
				for(int k=0;k<str.length();k++){
					arr[j].append(str.charAt(k));
				}
			}
			int len = findShortest(0,0,0);
		}
		sc.close();
	}
}
