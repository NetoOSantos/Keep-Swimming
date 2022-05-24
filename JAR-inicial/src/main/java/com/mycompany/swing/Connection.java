
package com.mycompany.swing;

import org.apache.commons.dbcp2.BasicDataSource;


public class Connection {
    private BasicDataSource datasource;
    private BasicDataSource dataSourceLocal;
    
    public Connection() {
        this.datasource = new BasicDataSource();
        
       // this.datasource.setDriverClassName("org.h2.Driver");
     this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
     //this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       
      //  this.datasource.setUrl("jdbc:h2:file:/home/aluno/.m2/repository/com/h2database/h2/1.4.199/meu_banco");
         // usuário padrao H2
      //  this.datasource.setUsername("sa");
      //  this.datasource.setPassword("");
     
      
      this.datasource.setUrl("jdbc:sqlserver://keepswimming.database.windows.net:1433;database=KeepSwimming;"
            + "user=KeepSwimmin@keepswimming;password=2ads@grupo8;encrypt=true;trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
      this.datasource.setUsername("KeepSwimmin@keepswimming");
      this.datasource.setPassword("2ads@grupo8");
    
      
      this.dataSourceLocal.setUrl("jdbc:mysql://localhost:3306/KeepSwimming?useTimezone=true&serverTimezone=UTC"); 
         // senha padrao utilizada no container MySQL
      this.dataSourceLocal.setUsername("urubu100");
      this.dataSourceLocal.setPassword("urubu100");
       
    }
    
     public BasicDataSource getDatasource() {
        return datasource;
    }
}
