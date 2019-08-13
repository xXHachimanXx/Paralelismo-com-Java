import java.util.concurrent.*;
import java.lang.Runnable;
import java.lang.Thread;

public class Tarefa extends Thread
{
    public final long valorInicial

}//end class Tarefa

public class Teste
{
    public static void main(String [] args)
    {
        Runnable rn = new Runnable()
        {
            @Override
            public void run()
            {
                //código para executar em paralelo
                System.out.println("ID: " + Thread.currentThread().getId());
                System.out.println("Nome: " + Thread.currentThread().getName());
                System.out.println("Prioridade: " + Thread.currentThread().getPriority());
                System.out.println("Estado: " + Thread.currentThread().getState());
            }
        };

        Thread th = new Thread(rn);
        th.start();
    }
}