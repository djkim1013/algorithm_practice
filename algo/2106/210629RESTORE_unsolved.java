import java.util.*;

public class Main {
	static final int BIGNUM = 0xfffffff;
	static String[] arr = new String[15];
	static int[] cache = new int[16];
	static int k;
	
	int findShortest(int idx, int used, int len){
		if(idx==k){
			if(len<cache[idx]){
				return len;
			}
			return cache[idx];
		}
		int ret = cache[idx];
		if(ret!=-1){
			
		}
		for(int i=0;i<k;i++){
			
		}
		ret = len;

		cache[idx] = len;
		return weaver(idx+1,);
	}

	String weaver(int len){
		char[] str = new char[len];
		return str.toString();
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int i=0;i<c;i++){
			n = sc.nextInt();
			Arrays.fill(cache,-1);
			for(int j=0;j<k;j++){
				arr[j] = sc.next();
			}
			int len = findShortest(0,0,0);
		}
		sc.close();
	}
}
