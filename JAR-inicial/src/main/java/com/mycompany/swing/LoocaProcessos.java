
package com.mycompany.swing;

import com.github.britooo.looca.api.group.processos.Processo;

public class LoocaProcessos {
    
    public Processo ProcessosEmUso;
    public Double usoCPU;
    public Long bytesUtilizados;
    public Long memVirtual;
    public Integer pid;
    public Integer totalProcessos;
    public Integer threads;

    public LoocaProcessos(Processo ProcessosEmUso, Double usoCPU, Long bytesUtilizados, Long memVirtual, Integer pid, Integer totalProcessos, Integer threads) {
        this.ProcessosEmUso = ProcessosEmUso;
        this.usoCPU = usoCPU;
        this.bytesUtilizados = bytesUtilizados;
        this.memVirtual = memVirtual;
        this.pid = pid;
        this.totalProcessos = totalProcessos;
        this.threads = threads;
    }

    public LoocaProcessos() {
    }

    public Double getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(Double usoCPU) {
        this.usoCPU = usoCPU;
    }

    public Long getBytesUtilizados() {
        return bytesUtilizados;
    }

    public void setBytesUtilizados(Long bytesUtilizados) {
        this.bytesUtilizados = bytesUtilizados;
    }

    public Long getMemVirtual() {
        return memVirtual;
    }

    public void setMemVirtual(Long memVirtual) {
        this.memVirtual = memVirtual;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    
    

    public Processo getProcessosEmUso() {
        return ProcessosEmUso;
    }

    public void setProcessosEmUso(Processo ProcessosEmUso) {
        this.ProcessosEmUso = ProcessosEmUso;
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
