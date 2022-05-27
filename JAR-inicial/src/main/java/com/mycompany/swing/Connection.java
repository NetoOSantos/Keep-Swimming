
package com.mycompany.swing;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Connection {
    
    private BasicDataSource datasource;
    
    public Connection() {
        this.datasource = new BasicDataSource();
        
        // Conexão com banco H2
        
      //  this.datasource.setUrl("jdbc:h2:file:/home/aluno/.m2/repository/com/h2database/h2/1.4.199/meu_banco");
      // this.datasource.setDriverClassName("org.h2.Driver");
            //  this.datasource.setUsername("sa");
            //  this.datasource.setPassword("");
      
//------------------------------------------------------------------------------
      
      // Conexão com banco MySQL Local
      
     // this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
     // this.datasource.setUrl("jdbc:mysql://localhost/KeepSwimming?useTimezone=true&serverTimezone=UTC"); 
            //this.datasource.setUsername("root");
            //this.datasource.setPassword("YES");
        
//------------------------------------------------------------------------------      
        
        // Conexão com banco AZURE
        
        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setUrl("jdbc:sqlserver://keepswimming.database.windows.net:1433;"
                + "database=KeepSwimming;user=KeepSwimmin@keepswimming;password=2ads@grupo8;"
                + "encrypt=true;trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
                this.datasource.setUsername("KeepSwimmin@keepswimming");
                this.datasource.setPassword("2ads@grupo8");
    
    }
    
     public BasicDataSource getDatasource() {
        return datasource;
    }

}
