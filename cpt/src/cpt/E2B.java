public class E2B extends Thread
        
{
    private static int tick = 0;
    public String Nom;
    public static int count = 0;
    
    public E2B (String name)
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
       System.out.println("Thread: " + Thread.currentThread().getName() + " ,tick = " + tick);
      }
     }
     
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
    }
    
    public static void main (String args [])
    {
     E2B Thread1 = new E2B("Processus1");
     E2B Thread2 = new E2B("Processus2");
     E2B Thread3 = new E2B("Processus3");
     
     Thread1.start(); 
     Thread2.start(); 
     Thread3.start();
     
     count = Thread.activeCount();
     
     System.out.println("Le nombre de Threads créés est: " + count);
    }
}