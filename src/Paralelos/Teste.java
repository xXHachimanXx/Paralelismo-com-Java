import java.util.concurrent.*;
import java.lang.Runnable;
import java.lang.Thread;

class Tarefa extends Thread
{    
    public final long long valorInicial;
    public final long long valorFinal;
    private long long total;

    /**
     * Construtor padrão
     */
    public Tarefa(long long vi, long long vf)
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
            total = total + 1;  
            
        //código para executar em paralelo
        /*
        System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Nome: " + Thread.currentThread().getName());
        System.out.println("Prioridade: " + Thread.currentThread().getPriority());
        System.out.println("Estado: " + Thread.currentThread().getState());          
        */
    }    

}//end class Tarefa

public class Teste
{
    public static void main(String [] args)
    {
        Tarefa t1 = new Tarefa(1, 1000000000);
        t1.setName("Tarefa 1"); //Método da classe Thread
        Tarefa t2 = new Tarefa(1000000001, 2000000000);
        t2.setName("Tarefa 2"); //Método da classe Thread
        Tarefa t3 = new Tarefa(2000000001, 3000000000);
        t3.setName("Tarefa 3"); //Método da classe Thread
                

        //Iniciar as tarefas e criar novas threads
        t1.start();
        t2.start();
        t3.start();
        int nucleos = Runtime.getRuntime().availableProcessors();

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
        System.out.println("Núcleos: " + nucleos);
    }
}