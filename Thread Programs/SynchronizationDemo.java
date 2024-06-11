//Thread synchronization- Two threads acting on same object
//Multiple Threads acting on single object 
class Reserve implements Runnable 
{  
  int available = 1; 
  int wanted; 
  Reserve (int i) 
  {  
    wanted = i; 
  } 
  public void run() 
  { 
    synchronized (this) 
    {  
	  System.out.println ("\n Number of berths available: " + available); 
      if ( available >= wanted) 
      {  
	    String name = Thread.currentThread ().getName (); 
        System.out.println ("\n"+wanted + " berths alloted to: " + name); 
        try 
        {  
		  Thread.sleep (2000); // wait for priniting the ticket 
          available = available - wanted; 
        } 
        catch (InterruptedException e) 
        {  
		   e.printStackTrace ();    
		} 
      }
      else 
      {    
	     System.out.println ("\n Sorry, no berths available"); 
      } 
    } 
  } 
}
class SynchronizationDemo
{  
  public static void main(String args[])  
  {  
    Reserve obj = new Reserve (1); 
    Thread t1 =new Thread (obj); 
    Thread t2 = new Thread (obj); 
	
    t1.setName ("First Person"); 
    t2.setName ("Second Person"); 
    t1.start (); 
    t2.start (); 
  } 
} 
