//Using ThreadGroup 
import java.io.*; 

class ThreadGroupDemo
{  
  public static void main (String args[]) throws IOException 
  {  
    Reservation   res = new Reservation (); 
    Cancellation  can = new Cancellation (); 
	
    //Create a ThreadGroup 
    ThreadGroup tg = new ThreadGroup ("Reservation Group"); 
	
    //Create 2 threads and add them to thread group 
    Thread t1 = new Thread (tg, res, "First Thread"); 
    Thread t2 = new Thread (tg, res, "Second Thread"); 
	
    //Create another thread group as a child to tg 
    ThreadGroup tg1 = new ThreadGroup (tg, "Cancellation Group"); 
    Thread t3 = new Thread (tg1, can, "Third Thread"); 
    Thread t4 = new Thread (tg1, can, "Fourth Thread"); 
	
    //find parent group of tg1 
    System.out.println ("\n Parent of tg1 = " + tg1.getParent ()); 
	
    //set maximum priority 
    tg1.setMaxPriority (7); 
	
    System.out.println ("\n Thread group of t1 = " + t1.getThreadGroup ()); 
	System.out.println ("\n Thread group of t2 = " + t2.getThreadGroup ()); 
    System.out.println ("\n Thread group of t3 = " + t3.getThreadGroup ()); 
	System.out.println ("\n Thread group of t4 = " + t4.getThreadGroup ()); 
    t1.start (); 
    t2.start (); 
    t3.start (); 
    t4.start (); 
    System.out.println ("\n Number of threads in this group : " + tg.activeCount()); 
  } 
} 
class Reservation extends Thread 
{  public void run () 
  {  System.out.println ("\n I am Reservation Thread"); 
  } 
} 
class Cancellation extends Thread 
{  public void run () 
  {  System.out.println ("\n I am Cancellation Thread"); 
  } 
}   
