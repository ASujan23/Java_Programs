import java.io.*;
import java.lang.*;

public class ExceptionDemo
{
   public static void main(String args[])throws IOException
   {
      int subject[]={12,23,34,21};
      try
      {
        System.out.println(subject[2]);
        System.out.println("not okay");
      }
      catch(Exception e)
     {
       System.out.println("i caught the exception:"+e);
        
     }
    finally
    {
      System.out.println("okay");
     }
  }
}
