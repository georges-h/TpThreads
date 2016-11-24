
public class E2C extends Thread     
{
    private static int tick = 0;    
    public String Nom;
    public static int count = 0;
    public E2C (String name)
    { 
     Nom = name;
    }
   
    @Override
    public void run ()
    {
     
     for (int i = 1 ; i <= count; i++)
     {
      System.out.println ("Nom Thread: " + Nom +  
      "\nGroupe: " + Thread.currentThread().getThreadGroup() +              
      "\nPriorité: " + Thread.currentThread().getPriority());
      if (Thread.currentThread().isDaemon())
      { 
       System.out.println("Je suis un Thread Demon");
      }
      else
      {
       System.out.println("Je ne suis pas un Thread Demon");
      }
     }
        
     while (tick <40000000)
     {
      tick++;
      if ((tick%5000)==0)
      {
       System.out.println("Thread: " + Thread.currentThread().getName() + " ,tick = " + tick);
      }
     }
    }
    
    public static void main (String args [])
    {
     E2C Thread1 = new E2C("Processus1");
     E2C Thread2 = new E2C("Processus2");
     E2C Thread3 = new E2C("Processus3");
     
     Thread1.start(); 
     Thread2.start(); 
     Thread3.start();
     
     count = Thread.activeCount();
     
     System.out.println("Le nombre de Threads créés est: " + count);
     
     try
     {
      Thread1.join();
      Thread2.join();
      Thread3.join();

      System.out.println("Fin de E2C");
      System.exit(0);
     }
     catch (InterruptedException e) 
     {
      System.out.println(e);
     }
    }
}