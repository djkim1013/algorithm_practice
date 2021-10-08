//BOJ: 1676
//2021.10.08
//category: 정수론 및 조합론
//review:

class Main{
    static public void main(String[] args)throws Exception{
        int c,n=System.in.read()-'0';
        while((c=System.in.read())>='0') n=n*10+c-'0';
        int two=0,five=0;
        for(int i=2;i<=n;i++){
            int x=i;
            while(x%2==0){
                two++;
                x/=2;
            }
            while(x%5==0){
                five++;
                x/=5;
            }
        }
        System.out.println(Math.min(two,five));
    }
}