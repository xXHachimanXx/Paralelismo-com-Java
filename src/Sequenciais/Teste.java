import java.util.concurrent.*;
import java.lang.Runnable;
import java.lang.Thread;

class Tarefa
{    
    public final long valorInicial;
    public final long valorFinal;
    private long total;

    /**
     * Construtor padrão.
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
    public void somar()
    {
        for(long y = valorInicial; y <= valorFinal; y++)
            total = total + 1;              
    }    

    public int [] ordenar(int [] vet)
    {
        int menor = 0;

        for(int x = 0; x < vet.length; x++)
        {
            for(int y = 0; y < vet.length; y++)
            {
                if(vet[y] <= menor)
                    menor = vet[y];
            }
            vet[x] = menor;
        }
    }

}//end class Tarefa

public class Teste
{
    public static void main(String [] args)
    {
        Tarefa t1 = new Tarefa(1, 1000000000);        
        Tarefa t2 = new Tarefa(1000000001, 2000000000);        
        Tarefa t3 = new Tarefa(2000000001, 3000000000);        
                
        t1.somar();
        t2.somar();
        t3.somar();        
        
        //Exibimos o somatório dos totalizadores de cada Thread
        System.out.println("Total: " + (t1.getTotal() + t2.getTotal() + t3.getTotal()));        
    }
}