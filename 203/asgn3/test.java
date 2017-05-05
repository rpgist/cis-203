import java.util.*;
import java.io.*;
public class test{
public static void main (String [] args) {
Reverser r = new Reverser(new File("test.txt"));
      try{
      r.reverseLines(new File("out1.txt"));
      System.out.println("ckpt1 cmpt");
      r.reverseEachLine(new File("out2.txt"));
      System.out.println("ckpt2 cmpt");
      r.completeReverse(new File("out3.txt"));
      System.out.println("ckpt3 cmpt");
      }catch(Exception e){
	  System.out.println(e);
      }
  }
}
