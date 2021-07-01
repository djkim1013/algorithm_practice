//AOJ: RESTORE
//2021.07.02
//문제 분류: 동적계획법
//해결 분석: 문자열의 길이가 최소화 되는 경우는 중복되는 길이가 최대화되는 경우와 같다.
// 			반드시 메모이제이션 값이 실제 문자열 길이일 필요는 없다.

// import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static String[] arr = new String[15];
	static int[] cache = new int[15*(1<<15)];
	static int[] overlap = new int[16*15];
	
	static void countOverlap(){
		for(int i=0;i<n;i++){
			String front = arr[i];
			for(int j=0;j<n;j++){
				String back = arr[j];
				int bCur = Math.min(front.length(),back.length());
				int fCur = front.length()-bCur;
				while(fCur<=front.length()&&bCur>0){
					if(front.substring(fCur).equals(back.substring(0, bCur))){
						overlap[15*i+j]=bCur;
						break;
					}
					fCur++;
					bCur--;
				}
			}
		}
	}

	static int findShort(int pre, int used){
		if(used == ((1<<15)-1)){
			return 0;
		}
		int ret = cache[pre*(1<<15)+used];
		if(ret!=-1) return ret;
		ret = 0;
		for(int i=0;i<n;i++){
			if((used&(1<<i))!=0)continue;
			int len = findShort(i,used|(1<<i));
			if(used>0) len+=overlap[pre*15+i];
			ret = Math.max(ret,len);
		}
		cache[pre*(1<<15)+used]=ret;
		return ret;
	}

	static String findShortStr(int pre, int used){
		for(int i=0;i<n;i++){
			if((used&(1<<i))!=0)continue;
			int len = findShort(i,used|(1<<i));
			if(used>0){
				len += overlap[pre*15+i];
			}
			if(findShort(pre,used)==len){
				if(used==0) return arr[i]+findShortStr(i,used|(1<<i));
				return arr[i].substring(overlap[pre*15+i])+findShortStr(i,used|(1<<i));
			}
		}
		return "!";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int ci=0;ci<c;ci++){
			n = sc.nextInt();
			Arrays.fill(cache,-1);
			Arrays.fill(arr,null);
			for(int i=0;i<n;i++){
				arr[i] = sc.next();
			}
			countOverlap();
			findShort(0,0);
			System.out.println(findShortStr(0,0));
		}
		sc.close();
	}
}
