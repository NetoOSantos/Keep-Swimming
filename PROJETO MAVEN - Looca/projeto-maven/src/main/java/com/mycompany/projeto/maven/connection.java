
package com.mycompany.projeto.maven;

import org.apache.commons.dbcp2.BasicDataSource;


public class connection {
    
    private BasicDataSource dataSource;

    public connection() {
        dataSource = new BasicDataSource();
        
        dataSource​.setDriverClassName("org.h2.Driver");
        dataSource​.setUrl("jdbc:h2:file:/D:\\SPTECH DIGITAL SCHOOL\\S02\\Linguagem de programação\\PROJETO MAVEN - Looca\\projeto-maven\\meu_banco");
        dataSource​.setUsername("sa");
        dataSource​.setPassword("");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
    
}
    

