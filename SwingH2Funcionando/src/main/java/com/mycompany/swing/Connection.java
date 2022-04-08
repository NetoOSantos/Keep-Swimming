
package com.mycompany.swing;

import org.apache.commons.dbcp2.BasicDataSource;


public class Connection {
    private BasicDataSource datasource;
    
    public Connection() {
        this.datasource = new BasicDataSource();
        
       // this.datasource.setDriverClassName("org.h2.Driver");
     this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       
      //  this.datasource.setUrl("jdbc:h2:file:/home/aluno/.m2/repository/com/h2database/h2/1.4.199/meu_banco");
      this.datasource.setUrl("jdbc:mysql://localhost/KeepSwimming?useTimezone=true&serverTimezone=UTC"); 

         // usuário padrao H2
      //  this.datasource.setUsername("sa");
        
         // usuário utilizado em um container MySQL
        this.datasource.setUsername("root");

        // senha padrao H2
      //  this.datasource.setPassword("");
        
         // senha padrao utilizada no container MySQL
        this.datasource.setPassword("YES");
    }
    
     public BasicDataSource getDatasource() {
        return datasource;
    }
}
