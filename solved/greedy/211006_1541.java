//BOJ: 1541
//2021.10.06
//category: 그리디 알고리즘
//review:

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int sum=0;
        int operator=1;
        StringBuilder number=new StringBuilder();
        for(char c:input){
            if(c=='+'){
                sum+=operator*Integer.parseInt(number.toString());
                number.delete(0,number.length());
            }else if(c=='-'){
                sum+=operator*Integer.parseInt(number.toString());
                number.delete(0,number.length());
                if(operator>0) operator*=-1;
            }else{
                number.append(c);
            }
        }
        sum+=operator*Integer.parseInt(number.toString());
        System.out.println(sum);
    }
}
