
package com.mycompany.swing;

public class LoocaHardware {
    
    public Integer memoria;
    public String processador;
    public Double temperatura;
    public Integer disco;
    public String sistema;

    public LoocaHardware(Integer memoria, String processador, Double temperatura, Integer disco, String sistema) {
        this.memoria = memoria;
        this.processador = processador;
        this.temperatura = temperatura;
        this.disco = disco;
        this.sistema = sistema;
    }
    
    public LoocaHardware() {
    }

    public Integer getMemoria() {
        return memoria;
    }

    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getDisco() {
        return disco;
    }

    public void setDisco(Integer disco) {
        this.disco = disco;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    @Override
    public String toString() {
        return "memoria=" + memoria + ", processador=" 
                + processador + ", temperatura=" + temperatura +
                ", disco=" + disco + ", sistema=" + sistema;
    }
    
    
    
}
