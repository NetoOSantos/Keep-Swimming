
package com.mycompany.swing;

public class LoocaProcessos {
    
    public Integer totalProcessos;
    public Integer threads;

    public LoocaProcessos(Integer totalProcessos, Integer threads) {
        this.totalProcessos = totalProcessos;
        this.threads = threads;
    }
    
    public LoocaProcessos() {
    }
    
    public Integer getTotalProcessos() {
        return totalProcessos;
    }

    public void setTotalProcessos(Integer totalProcessos) {
        this.totalProcessos = totalProcessos;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    @Override
    public String toString() {
        return String.format("Total de Processos = %d"
                             + "\nThreads = %d",
                             totalProcessos,
                             threads);
    }
    
    
   
}
