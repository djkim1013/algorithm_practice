//AOJ: ZIMBABWE (https://www.algospot.com/judge/problem/read/ZIMBABWE)
//2021.06.23
//문제 분류: 동적계획법
//해결 분석: 
import java.util.*;

public class Main {
	
	static final int mod = 1000000007;
	static String e, plates;
	static int n, m;
	
	static int generate(String price, boolean[] taken) {
		int len=price.length(); 
		if(len==n) {
			if(price.compareTo(e)<0) {
//				System.out.println("price "+price);
				return 1;
			}
			return 0;
		}
		int answer=0;
		for(int i=0;i<n;i++) {
			if(!taken[i]&&
					(i==0||plates.charAt(i)!=plates.charAt(i-1)||taken[i-1])) {
				boolean[] takenCp=Arrays.copyOf(taken,taken.length);
				takenCp[i]=true;
				answer+=generate(price+plates.charAt(i),takenCp);
				answer%=mod;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		for(int i=0;i<c;i++) {
			e=sc.next();
			n=e.length();	
			m=sc.nextInt();

			char[] eSort=e.toCharArray();
			Arrays.sort(eSort);
			plates=String.valueOf(eSort);
			System.out.println(plates);
			
			boolean[] taken= new boolean[n];
			for(boolean v:taken)System.out.print(v+" ");
			System.out.println();
			System.out.println(generate("",taken));
		}
		
	}

}
