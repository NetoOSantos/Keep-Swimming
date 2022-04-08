
package com.mycompany.swing;


public class LoocaDB {
   
     public  Integer ID;
     public  String SistemaOperacional;
     public String Fabricante;
    public Integer Arquitetura;

    @Override
    public String toString() {
        return String.format("ID = %d"
                            + "\nSistema Operacional = %s"
                            + "\nFabricante = %s"
                            + "\nArquitetura = %s"
                            + "\nInicializado = %s"
                            + "\nTempo de atividade = %s"
                            + "\nPermissões = %s",
                            ID,
                            SistemaOperacional,
                            Fabricante,
                            Arquitetura,
                            Inicializado,
                            TempoDeAtividade,
                            Permissoes);
    }
    public String Inicializado;
    public String TempoDeAtividade;
    public String Permissoes;

    public LoocaDB() {
    }

    public LoocaDB(Integer ID, String SistemaOperacional, String Fabricante, Integer Arquitetura, String Inicializado, String TempoDeAtividade, String Permissoes) {
        this.ID = ID;
        this.SistemaOperacional = SistemaOperacional;
        this.Fabricante = Fabricante;
        this.Arquitetura = Arquitetura;
        this.Inicializado = Inicializado;
        this.TempoDeAtividade = TempoDeAtividade;
        this.Permissoes = Permissoes;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSistemaOperacional() {
        return SistemaOperacional;
    }

    public void setSistemaOperacional(String SistemaOperacional) {
        this.SistemaOperacional = SistemaOperacional;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Integer getArquitetura() {
        return Arquitetura;
    }

    public void setArquitetura(Integer Arquitetura) {
        this.Arquitetura = Arquitetura;
    }

    public String getInicializado() {
        return Inicializado;
    }

    public void setInicializado(String Inicializado) {
        this.Inicializado = Inicializado;
    }

    public String getTempoDeAtividade() {
        return TempoDeAtividade;
    }

    public void setTempoDeAtividade(String TempoDeAtividade) {
        this.TempoDeAtividade = TempoDeAtividade;
    }

    public String getPermissoes() {
        return Permissoes;
    }

    public void setPermissoes(String Permissoes) {
        this.Permissoes = Permissoes;
    }

}
