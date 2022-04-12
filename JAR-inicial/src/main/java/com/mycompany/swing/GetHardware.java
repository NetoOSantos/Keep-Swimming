package com.mycompany.swing;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetHardware {

    public static void main(String[] args) {
        
        Connection con = new Connection();
        
        JdbcTemplate template = new JdbcTemplate(con.getDatasource());
        
//-----------------------------------------------------------------------------        

        DiscosGroup disco = new DiscosGroup();
        
        List<Disco> listaDeDisco = disco.getDiscos();

        Memoria memoria = new Memoria();
        
        Processador processador = new Processador();
        
        Temperatura temperatura = new Temperatura();
        
//-----------------------------------------------------------------------------        

        String criarTabelaHardware = "CREATE TABLE IF NOT EXISTS Hardware (\n"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,\n"
                + "qtdDiscos int,\n"
                + "nomeDisco varchar(50),\n"
                + "tamanhoDisco Double,\n"
                + "memoriaTotal Double,\n"
                + "processadorNome varchar(50),\n"
                + "temperaturaAtual Double\n"
                + ");";
        
        //template.execute(criarTabelaHardware);

        for (int i = 0; i < listaDeDisco.size() ; i++) {
            
            Integer qtdDiscos = disco.getQuantidadeDeDiscos();
            String nomeDisco = listaDeDisco.get(i).getNome();
            Long tamanhoDisco = listaDeDisco.get(i).getTamanho();
            Long memoriaTotal = memoria.getTotal();
            String processadorNome = processador.getNome();
            Double temperaturaAtual = temperatura.getTemperatura();
            
            String inserirDadosHardware = "Insert into Hardware VALUES "
                    + "(null,?,?,?,?,?,?);";

            template.update(inserirDadosHardware,
                            qtdDiscos, 
                            nomeDisco,
                            tamanhoDisco,
                            memoriaTotal,
                            processadorNome,
                            temperaturaAtual);
        }
        
        List<LoocaHardware> loocaHardwares = template.query("select * from Hardware",
                new BeanPropertyRowMapper<>(LoocaHardware.class));

        for (LoocaHardware Hardware : loocaHardwares) {

            System.out.println(Hardware);
            System.out.println("-".repeat(50));
        }

    }

}
