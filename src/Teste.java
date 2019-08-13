import java.util.concurrent.*;
import java.lang.Runnable;
import java.lang.Thread;

class Tarefa extends Thread
{    
    public final long valorInicial;
    public final long valorFinal;
    private long total;

    /**
     * Construtor padrão
     */
    public Tarefa(long vi, long vf)
    {
        this.valorInicial = vi;
        this.valorFinal = vf;        
    }

    public long getTotal()
    { return this.total; }

    /**
     * Método para rodar a aplicação em paralelo.
     */
    @Override
    public void run()
    {
        for(long y = valorInicial; y <= valorFinal; y++)
            total = total + y;  
            
        //código para executar em paralelo
        System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Nome: " + Thread.currentThread().getName());
        System.out.println("Prioridade: " + Thread.currentThread().getPriority());
        System.out.println("Estado: " + Thread.currentThread().getState());          
    }    

}//end class Tarefa

public class Teste
{
    public static void main(String [] args)
    {
        Tarefa t1 = new Tarefa(0, 1000);
        t1.setName("Tarefa 1"); //Método da classe Thread
        Tarefa t2 = new Tarefa(1001, 2000);
        t2.setName("Tarefa 2"); //Método da classe Thread
        Tarefa t3 = new Tarefa(2001, 3000);
        t3.setName("Tarefa 3"); //Método da classe Thread
                

        //Iniciar as tarefas e criar novas threads
        t1.start();
        t2.start();
        t3.start();

        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }

        //Exibimos o somatório dos totalizadores de cada Thread
        System.out.println("Total: " + (t1.getTotal() + t2.getTotal() + t3.getTotal()));
    }
}