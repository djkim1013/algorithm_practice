//AOJ: ZIMBABWE
//2021.06.28
//문제 분류: 동적계획법
//해결 분석: 처음 수보다 작은 조건, 주어진 수의 배수인 조건을 미리 걸러내서 메모이제이션하는 과정이 필요하다.
//	    채점페이지에서 입출력에 Scanner/println을 사용하면 시간초과가 발생한다.

import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;
	static String e, plates;
	static int n, m;
	static int[] cache = new int[(1<<14)*20*2];
	
	static int generate(int idx, int taken, int mod, int less) {
		if (idx == n) {
			return (less == 1 && mod == 0) ? 1 : 0;
		}
		int ret = cache[taken*20*2+mod*2+less];
		if (ret != -1) return ret;
		ret = 0;
		for (int i = 0; i < n; i++) {
			if ((taken & (1<<i)) == 0 ){
				if (less == 0 && e.charAt(idx) < plates.charAt(i))
					continue;
				if (i > 0 && plates.charAt(i) == plates.charAt(i-1) && (taken & 1 << (i-1)) == 0)
					continue;
				int takenNext = taken | (1 << i);
				int modNext = (mod * 10 + plates.charAt(i) - '0') % m;
				int lessNext = (less == 1 || e.charAt(idx) > plates.charAt(i)) ? 1 : 0;
				ret += generate(idx + 1, takenNext, modNext, lessNext);
				ret %= MOD;
			}
		}
        cache[taken*20*2+mod*2+less] = ret;
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			e = st.nextToken();
			n = e.length();	
			m = Integer.parseInt(st.nextToken());
			Arrays.fill(cache, -1); 
			char[] eSort = e.toCharArray();
			Arrays.sort(eSort);
			plates = String.valueOf(eSort);
			
			bw.append(generate(0, 0, 0, 0)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
