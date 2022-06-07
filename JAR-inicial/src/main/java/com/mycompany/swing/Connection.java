
package com.mycompany.swing;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author  WalderleyNeto e Bruno Henrrigue
 */
public class Connection {
    
    private BasicDataSource datasource;
    private BasicDataSource dataSourcelocal;
    
        public Connection() {
            Log log = new Log();
            
            log.criarLog("=====Buscasndo conexão com BD=====");
              
        // Conexão com banco AZURE
        datasource = new BasicDataSource();
        datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        datasource.setUrl("jdbc:sqlserver://keepswimming.database.windows.net:1433;"
                + "database=KeepSwimming;user=KeepSwimmin@keepswimming;password=2ads@grupo8;"
                + "encrypt=true;trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
                datasource.setUsername("KeepSwimmin@keepswimming");
                datasource.setPassword("2ads@grupo8");
                
//         Conexão com banco H2
//        this.datasource.setUrl("jdbc:h2:file:/home/aluno/.m2/repository"
//                + "/com/h2database/h2/1.4.199/meu_banco");
//       this.datasource.setDriverClassName("org.h2.Driver");
//              this.datasource.setUsername("sa");
//              this.datasource.setPassword("");

      // Conexão com banco MySQL Local
        dataSourcelocal = new BasicDataSource();
        dataSourcelocal.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourcelocal.setUrl("jdbc:mysql://172.17.0.2:3306/keepSwimming?autoReconnect=true&useSSL=false&serverTimezone=UTC"); 
              dataSourcelocal.setUsername("root");
              dataSourcelocal.setPassword("urubu100");
    }
        
 
     public BasicDataSource getDatasource() {
        return datasource;
    }

    public BasicDataSource getDataSourcelocal() {
        return dataSourcelocal;
    }
     
}
