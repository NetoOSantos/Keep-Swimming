
package com.mycompany.swing;


public class Funcionario {
    public int ID;
    public String EMAIL;
    public String SENHA;
    public Integer idMaquina;

    public Funcionario() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    

     public Integer getIdMaquina() {
        return idMaquina;
    }
     
     public void setIdMaquina()
     {
         this.idMaquina = idMaquina;
     }
    
    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }
    
}
