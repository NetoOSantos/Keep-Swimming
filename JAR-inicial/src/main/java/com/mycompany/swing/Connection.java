
package com.mycompany.swing;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Connection {
    private BasicDataSource datasource;
    private BasicDataSource dataSourceLocal;
    
        public Connection() {
            Log log = new Log();
            
            log.criarLog("=====Buscasndo conexão com BD=====");

        this.datasource = new BasicDataSource();
        
       // this.datasource.setDriverClassName("org.h2.Driver");
    // this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
     //this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       
      //  this.datasource.setUrl("jdbc:h2:file:/home/aluno/.m2/repository/com/h2database/h2/1.4.199/meu_banco");
     // this.datasource.setUrl("jdbc:mysql://localhost/KeepSwimming?useTimezone=true&serverTimezone=UTC"); 
    //this.datasource.setUrl("jdbc:sqlserver://keepswimming.database.windows.net:1433;database=KeepSwimming;user=KeepSwimmin@keepswimming;password=2ads@grupo8;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    
         // usuário padrao H2
      //  this.datasource.setUsername("sa");
        
         // usuário utilizado em um container MySQL
    //    this.datasource.setUsername("root");
        
   // public Connection(Boolean mysql){

      // Conexão com banco MySQL Local
     //   datasource = new BasicDataSource();
       // datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //datasource.setUrl("jdbc:mysql://172.17.0.2:3306/keep?autoReconnect=true&useSSL=false"); 
          //    datasource.setUsername("root");
            //  datasource.setPassword("root");

    //}
        //usuário AZURE
        this.datasource.setUsername("KeepSwimmin@keepswimming");

        // senha padrao H2
      //  this.datasource.setPassword("");
        
         // senha padrao utilizada no container MySQL
      //  this.datasource.setPassword("YES");
       
       //senha padrao AZURE
      this.datasource.setPassword("2ads@grupo8");
    }
    
     public BasicDataSource getDatasource() {
        return datasource;
    }

   
}
