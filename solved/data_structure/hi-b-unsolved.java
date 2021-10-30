import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        List<Integer> chocolete=new LinkedList<>();
        for(int i=0;i<n;i++) chocolete.add(Integer.parseInt(st.nextToken()));
        int sum=0, day=0;;
        while(true){
            int cur=-1;
            int max=0;
            for(int i=0;i+k<n;i++){
                if(chocolete.get(i+k)-chocolete.get(i)>max){
                    cur=i;
                    max=chocolete.get(i+k)-chocolete.get(i);
                }
            }
            if(cur==-1) break;
            chocolete.add(cur,chocolete.remove(cur+k)-max);
            sum+=max;
            day++;
        }
        System.out.println(sum+" "+day);
    }
}