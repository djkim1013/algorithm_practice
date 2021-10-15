//BOJ 11444
//2021.10.15
//category: 분할정복
//review:
//      - 행렬의 제곱을 이용한다.
//       : {{An+2}, {An+1}} = {{1, 1},{1, 0}}x{{An+1}, {An}}
//      - n=1 일때 A0이 호출됨에 주의

import java.io.*;

class Main{
    static final int MOD=1000000007;

    static int[][] multiple(int[][] a, int[][] b){
        int r=a.length, c=b[0].length, n=a[0].length;
        int[][] ret=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                long sum=0;
                for(int k=0;k<n;k++){
                    sum+=(long)a[i][k]*b[k][j]%MOD;
                    sum%=MOD;
                }
                ret[i][j]=(int)sum;
            }
        }
        return ret;
    }

    static int[][] power(final int[][] a, long k){
        if(k==0) return new int[][]{{1,0},{0,1}};
        if(k==1) return a;
        int[][] ret=power(a,k/2);
        ret=multiple(ret,ret);
        if(k%2==1) ret=multiple(ret,a);
        return ret;
    }

    public static void main(String[] args)throws Exception{
        long n=Long.parseLong((new BufferedReader(new InputStreamReader(System.in))).readLine());
        int[][] matrix=new int[][]{{1,1},{1,0}};
        matrix=power(matrix,n-1);
        matrix=multiple(matrix,new int[][]{{1},{0}});
        System.out.println(matrix[0][0]);
    }
}