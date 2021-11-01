//boj 23292
//2021.10.30
//category: 구현
//review:

import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String birthDay=br.readLine();
        int n=Integer.parseInt(br.readLine());
        String bestDay=null;
        int max=0;
        while(n-->0){
            String codingDay=br.readLine();
            if(bestDay==null) bestDay=codingDay;
            int bioY=0;
            for(int i=0;i<4;i++){
                int temp=birthDay.charAt(i)-codingDay.charAt(i);
                bioY+=temp*temp;
            }
            int bioM=0;
            for(int i=4;i<6;i++){
                int temp=birthDay.charAt(i)-codingDay.charAt(i);
                bioM+=temp*temp;
            }
            int bioD=0;
            for(int i=6;i<8;i++){
                int temp=birthDay.charAt(i)-codingDay.charAt(i);
                bioD+=temp*temp;
            }
            int bio=bioY*bioM*bioD;
            if(max<bio){
                max=bio;
                bestDay=codingDay;
            }else if(max==bio){
                if(bestDay.compareTo(codingDay)>0) bestDay=codingDay;
            }
        }
        System.out.println(bestDay);
    }
}
