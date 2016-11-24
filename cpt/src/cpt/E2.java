public class E2 extends Thread
        
{
    
    private static int tick = 0;
    private final String Nom;
    
    public E2 (String name)
    { 
     Nom = name;
    }
   
    @Override
    public void run ()
    {
     while (tick <40000000)
     {
      tick++;
      if ((tick%5000)==0)
      {
       System.out.println("Thread #" + Thread.currentThread().getName() + " tick = " + tick);
      }
     }
    }
    
    public static void main (String args [])
    {
     E2 Thread1 = new E2("Processus1");
     E2 Thread2 = new E2("Processus2");
     E2 Thread3 = new E2("Processus3");
     
     Thread1.start(); 
     Thread2.start(); 
     Thread3.start();
    }
}