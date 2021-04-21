package Problems;

import java.io.*;


class PrintCount {
  public static void main (String[] args) throws IOException {
    //Just for example - we will have streamed data
    String str="He\nll\r\noWo\rl\nd!!!\r\n\r"; // Line count for this =6
    InputStream inputstream=new ByteArrayInputStream(str.getBytes());
  //  System.out.println(str);
    int result = getLineCount(inputstream);
    System.out.println(result);
  }
/*
Implement a method to count the number of lines present in InputStream 
Identifiers for new line - \n ,\r, \r\n 
*/
public static int getLineCount(InputStream inputstream) throws IOException{
   byte[] data = new byte[5];//Can read 5 bytes at once
   int   bytesRead = inputstream.read(data);
   int count=0;
   int i=0;
   BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
   while(bytesRead != 0){
	   bytesRead--;
	   
   }
   return count;
 }


}
