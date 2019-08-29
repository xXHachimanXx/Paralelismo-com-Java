import java.util.*;
import java.lang.Runnable;
import java.lang.Thread;

public class Teste2
{
    public static final Integer QUANTIDADE = 1000;
    public static int var = 0;
    public static final List<Integer> VALORES = Collections.synchronizedList(new ArrayList<>());

    public static void main(String [] args)
    {
        Thread t1 =  new Thread( new Runnable ()
        {
            @Override
            public void run()
            {
                for(int y = 0; y < QUANTIDADE; y++)
                {
                    VALORES.add(1);
                }
            }
        });

        Thread t2 =  new Thread( new Runnable ()
        {
            @Override
            public void run()
            {                
                for(int y = 0; y < QUANTIDADE; y++)
                {
                    VALORES.add(1);
                }
            }
        });
        
        Thread t3 =  new Thread( new Runnable ()
        {
            @Override
            public void run()
            {                
                for(int y = 0; y < QUANTIDADE; y++)
                {
                    VALORES.add(1);
                }
            }
        });

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

        Integer soma = 0;
        for(Integer valor : VALORES)
        {
            soma = soma + valor;
        }

        //Exibimos o somatório dos totalizadores de cada Thread
        System.out.println("Total: " + (soma));
    }
}