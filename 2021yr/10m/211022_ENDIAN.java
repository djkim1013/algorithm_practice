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
	  long temp=0xff&n;
	  temp=(temp<<8)+(0xff&(n>>8));
	  temp=(temp<<8)+(0xff&(n>>16));
	  temp=(temp<<8)+(0xff&(n>>24));
	  answer.append(temp).append("\n");
	}
	System.out.print(answer);
  }
}