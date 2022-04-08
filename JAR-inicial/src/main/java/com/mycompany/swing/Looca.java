
package com.mycompany.swing;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.javafaker.Faker;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class Looca {
    public static void main(String[] args) {
          Connection config = new Connection();
        
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        LoocaDB loocadb = new LoocaDB();
        
// ------------------------------------------------        
        
     //   Faker faker = new Faker();
        
 //       System.out.println(faker.name().fullName());
        
    //    System.out.println("=".repeat(30));

// ------------------------------------------------
        
  com.github.britooo.looca.api.core.Looca looca = new com.github.britooo.looca.api.core.Looca();
        
        String sO = looca.getSistema().getSistemaOperacional();
        String fabricante = looca.getSistema().getFabricante();
        Integer arquitetura = looca.getSistema().getArquitetura();
        String inicializado = looca.getSistema().getInicializado().toString();
        String tempAtividade = looca.getSistema().getTempoDeAtividade().toString();
        String permissao = looca.getSistema().getPermissao().toString();
        
     
        
        
         con.execute("DROP TABLE IF EXISTS Sistema");
         
           String criarTabelaSistema = "CREATE TABLE Sistema (\n" +
                                "ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                                "SistemaOperacional varchar(50),\n" +
                                "Fabricante varchar(50),\n" +
                                "Arquitetura int,\n" +
                                "Inicializado varchar(50),\n" +
                                "TempoDeAtividade varchar(50),\n" +
                                "Permissoes varchar(50)\n" +
                                ");";
           con.execute(criarTabelaSistema);
           
           
           
          String inserirDadosSistema = "Insert into Sistema VALUES "
                   + "(null,?,?,?,?,?,?);";
           
  con.update(inserirDadosSistema,sO,fabricante,arquitetura,inicializado,tempAtividade,permissao);
           
            List<LoocaDB> LoocaSistema = con.query("select * from Sistema", 
                new BeanPropertyRowMapper<>(LoocaDB.class));
            
         for (LoocaDB hardware : LoocaSistema) {

            System.out.println(hardware);

        }
        
          
//         System.out.println("=".repeat(30));
  //      System.out.println(looca.getGrupoDeProcessos());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getGrupoDeServicos());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getMemoria());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getProcessador());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getTemperatura());
        
//        System.out.println("=".repeat(30));
        
// --------------------------------------------------      
        
//        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
//        
//        List<Disco> discos = grupoDeDiscos.getDiscos();
//        
//        for (Disco disco : discos) {
//            System.out.println(disco);
//        }
    }
}
