//BOJ 23293
//2021.10.30
//category: 자료구조
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] position=new int[n+1];
        Arrays.fill(position,1);
        ArrayList<Integer>[] inventory=(ArrayList<Integer>[])new ArrayList[n+1];
        ArrayList<Integer> abusing=new ArrayList<Integer>();
        ArrayList<Integer> blocked=new ArrayList<Integer>();
        for(int i=1;i<=n;i++) inventory[i]=new ArrayList<Integer>();
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int no=Integer.parseInt(st.nextToken());
            int user=Integer.parseInt(st.nextToken());
            char command=st.nextToken().charAt(0);
            switch(command){
                case 'M':{
                    position[user]=Integer.parseInt(st.nextToken());
                    break;
                }
                case 'F':{
                    int item=Integer.parseInt(st.nextToken());
                    if(item!=position[user]) abusing.add(no);
                    inventory[user].add(item);
                    break;
                }
                case 'C':{
                    int item1=Integer.parseInt(st.nextToken());
                    int item2=Integer.parseInt(st.nextToken());
                    if(inventory[user].contains(item1)&&inventory[user].contains(item2)){
                        inventory[user].remove(inventory[user].indexOf(item1));
                        inventory[user].remove(inventory[user].indexOf(item2));
                    }else{
                        abusing.add(no);
                        if(inventory[user].contains(item1)) inventory[user].remove(inventory[user].indexOf(item1));
                        if(inventory[user].contains(item2)) inventory[user].remove(inventory[user].indexOf(item2));
                    }
                    break;
                }
                case 'A':{
                    int target=Integer.parseInt(st.nextToken());
                    if(position[user]!=position[target]){
                        abusing.add(no);
                        if(!blocked.contains(user)) blocked.add(user);
                    }
                }
            }
        }
        bw.write(abusing.size()+"\n");
        if(abusing.size()>0){
            bw.write(abusing.toString().replaceAll("[\\[\\],]","")+"\n");
        }
        bw.write(blocked.size()+"\n");
        if(blocked.size()>0){
            Collections.sort(blocked);
            bw.write(blocked.toString().replaceAll("[\\[\\],]","")+"\n");
        }
        bw.flush();
    }
}
