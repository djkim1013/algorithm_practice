//AOJ: RESTORE
//2021.07.05
//문제 분류: 동적계획법
//해결 분석: 문자열의 길이가 최소화 되는 경우는 중복되는 길이가 최대화되는 경우와 같다.
// 			반드시 메모이제이션 값이 실제 문자열 길이일 필요는 없다.
//	+ 처음에 제외할 수 있는 조건-다른 문자열에 포함되는 경우-를 먼저 제외하고 시작한다.

// import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static String[] arr = new String[15];
	static int[][] cache = new int[15][1<<15];
	static int[][] overlap = new int[15][15];
	
	static void countOverlap(){
		for(int i=0;i<n;i++){
			String front = arr[i];
			for(int j=0;j<n;j++){
				if(i==j) continue;
				String back = arr[j];
				int len = Math.min(front.length(),back.length());
				for(int k=len;k>0;k--){
					String subBack = back.substring(0, k);
					if(front.endsWith(subBack)){
						overlap[i][j]=k;
						break;
					}
				}
			}
		}
	}

	static int findShort(int pre, int used){
		if(used == ((1<<n)-1)){
			return 0;
		}
		int ret = cache[pre][used];
		if(ret!=-1) return ret;
		ret = 0;
		for(int i=0;i<n;i++){
			if((used&(1<<i))!=0) continue;
			int len = findShort(i,used|(1<<i));
			if(used>0) len += overlap[pre][i];
			ret = Math.max(ret,len);
		}
		cache[pre][used]=ret;
		return ret;
	}

	static String findShortStr(int pre, int used){
		if(used==((1<<n)-1)){
			return "";
		}
		for(int i=0;i<n;i++){
			if((used&(1<<i))!=0) continue;
			int len = findShort(i,used|(1<<i));
			if(used>0) len += overlap[pre][i];
			if(findShort(pre,used)==len){
				String str = "";
				if(used>0){
					str += arr[i].substring(overlap[pre][i]);
				} else {
					str += arr[i];
				}
				return str + findShortStr(i,used|(1<<i));
			}
		}
		return "!";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		String[] answer = new String[c];
		for(int ci=0;ci<c;ci++){
			for(int i=0;i<15;i++){
				Arrays.fill(cache[i],-1);
				Arrays.fill(overlap[i],0);
			}

			n = sc.nextInt();

			for(int i=0;i<n;i++){
				arr[i] = sc.next();
			}

			//다른 문자열에 완전이 포함되는 문자열 제거
			for(int i=0;i<n;i++){
				String front = arr[i];
				for(int j=0;j<n;j++){
					if(i==j) continue;
					String back = arr[j];
					if(front.contains(back)){
						for(int k=j;k+1<n;k++){
							arr[k]=arr[k+1];
						}
						n--;
						if(i>j)i--;
						j--;
					}
				}
			}

			countOverlap();
			findShort(0,0);
			answer[ci]=findShortStr(0,0);
		}
		for(String a:answer) System.out.println(a);
		sc.close();
	}
}
