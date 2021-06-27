//AOJ: ZIMBABWE
//2021.06.28
//문제 분류: 동적계획법
//해결 분석: 처음 수보다 작은 조건, 주어진 수의 배수인 조건을 미리 걸러내서 메모이제이션하는 과정이 필요하다.
//		java로 작성하였을 때 채점페이지에서는 시간초과가 발생한다.

//package javaCode.javaCode.src;

import java.util.*;

public class Main {
    static final int MOD = 1000000007;
	String e, plates;
	int n, m;
	int[][][] cache = new int[1<<14][20][2];
	
	static int generate(Main m, int idx, int taken, int mod, int less) {
		if (idx == m.n) {
			return (less == 1 && mod == 0) ? 1 : 0;
		}
		int ret = m.cache[taken][mod][less];
		if (ret != -1) return ret;
		ret = 0;
		for (int i = 0; i < m.n; i++) {
			if ((taken & (1<<i)) == 0 ){
				if (less == 0 && m.e.charAt(idx) < m.plates.charAt(i))
					continue;
				if (i > 0 && m.plates.charAt(i) == m.plates.charAt(i-1) && (taken & 1 << (i-1)) == 0)
					continue;
				int takenNext = taken | (1 << i);
				int modNext = (mod * 10 + m.plates.charAt(i) - '0') % m.m;
				int lessNext = (less == 1 || m.e.charAt(idx) > m.plates.charAt(i)) ? 1 : 0;
				ret += generate(m, idx + 1, takenNext, modNext, lessNext);
				ret %= MOD;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		Main m = new Main();
		for(int i = 0; i < c; i++) {
			m.e = sc.next();
			m.n = m.e.length();	
			m.m = sc.nextInt();
			for (int j = 0; j < (1<<14); j++){
				for(int k = 0; k < 20; k++){
					Arrays.fill(m.cache[j][k],-1);
				} 
			}
			char[] eSort = m.e.toCharArray();
			Arrays.sort(eSort);
			m.plates = String.valueOf(eSort);
			
			System.out.println(generate(m, 0, 0, 0, 0));
		}	
	}

}
