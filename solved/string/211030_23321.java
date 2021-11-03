//BOJ 23321 홍대 경진대회 B
//2021.10.30
//category: 구현, 문자열
//review:

import java.io.*;

class Main{
    static final String[] type=new String[]{
        "..oLn",
        ".omln",
        "owln."
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] picture=new String[5];
        for(int i=0;i<5;i++) picture[i]=br.readLine();
        int[] position=new int[picture[0].length()];
        for(int i=0;i<position.length;i++){
            char c=picture[2].charAt(i);
            if(c=='m') position[i]=2;
            else if(c=='l') position[i]=1;
        }
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<5;i++){
            for(int j:position){
                answer.append(type[j].charAt(i));
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}