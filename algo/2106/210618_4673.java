//baekjoon : 4673
//21.06.18

public class Main{
    static boolean[] done=new boolean[10001];
    static void findSelfNum(int n,boolean d){
        if(done[n])return;
        if(d)done[n]=true;
        int nCp=n;
        int[] nArr=new int[5];
        for(int i=0;i<5||nCp>0;i++){
            nArr[i]=nCp%10;
            nCp/=10;
        }
        nCp=n;
        for(int i=0;i<5;i++){
            nCp+=nArr[i];
        }
        if (nCp<=10000)findSelfNum(nCp,true);
        return;
    }
    public static void main(String[] arg){
        for(int i=1;i<=10000;i++)
            findSelfNum(i,false);
        for(int i=1;i<=10000;i++){
            if(!done[i])System.out.println(i);
        }
    }
}
