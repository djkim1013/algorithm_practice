//AOJ ENDIAN
//2021.10.22
//category: 
//review:

import java.io.*;

class Main{
  public static void main(String[] args)throws Exception{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringBuilder answer=new StringBuilder();
	long c=Long.parseLong(br.readLine());
	while(c-->0){
	  long n=Long.parseLong(br.readLine());
	  n=((0xff&n)<<24)|((0xff00&n)<<8)|((0xff0000&n)>>8)|((0xff000000&n)>>24);
	  answer.append(n).append("\n");
	}
	System.out.print(answer);
  }
}