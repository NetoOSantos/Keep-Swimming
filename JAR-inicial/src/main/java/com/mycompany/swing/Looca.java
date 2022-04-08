package com.mycompany.swing;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.javafaker.Faker;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Looca {

    public static void main(String[] args) {

        // classe de de conexão com o banco
        Connection config = new Connection();

        //conexão com o banco
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        // looca
        com.github.britooo.looca.api.core.Looca looca = new com.github.britooo.looca.api.core.Looca();

        // Insersão dos dados do sistema no banco
        LoocaSistema loocadb = new LoocaSistema();

        // Insersão dos dados dos processos no banco
        LoocaProcessos loocaProcess = new LoocaProcessos();
        
        // Insersão dos dados de hardware no banco
        LoocaHardware loocaHardwr = new LoocaHardware();

        // ------------------------------------------------        
        System.out.println("=".repeat(40));

        // faker trás um nome de usuario randomico
        Faker faker = new Faker();
        
        System.out.println(faker.name().fullName());
        
        System.out.println("=".repeat(30));
        // -------------------------------------------------------------------------
        System.out.println("=".repeat(40));

        // Listando e inserindo dados do Sistema no banco
        String sO = looca.getSistema().getSistemaOperacional();
        String fabricante = looca.getSistema().getFabricante();
        Integer arquitetura = looca.getSistema().getArquitetura();
        String inicializado = looca.getSistema().getInicializado().toString();
        String tempAtividade = looca.getSistema().getTempoDeAtividade().toString();
        String permissao = looca.getSistema().getPermissao().toString();

        con.execute("DROP TABLE IF EXISTS Sistema");

        String criarTabelaSistema = "CREATE TABLE Sistema (\n"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,\n"
                + "SistemaOperacional varchar(50),\n"
                + "Fabricante varchar(50),\n"
                + "Arquitetura int,\n"
                + "Inicializado varchar(50),\n"
                + "TempoDeAtividade varchar(50),\n"
                + "Permissoes varchar(50)\n"
                + ");";

        con.execute(criarTabelaSistema);

        String inserirDadosSistema = "Insert into Sistema VALUES "
                + "(null,?,?,?,?,?,?);";

        con.update(inserirDadosSistema, sO, fabricante, arquitetura, inicializado, tempAtividade, permissao);

        List<LoocaSistema> LoocaSistema = con.query("select * from Sistema",
                new BeanPropertyRowMapper<>(LoocaSistema.class));

        for (LoocaSistema sistema : LoocaSistema) {

            System.out.println(sistema);
        }

        // -------------------------------------------------------------------------        
        // Listando e inserindo dados dos processos no banco
        System.out.println("=".repeat(40));
        
        String processosEmUso = looca.getGrupoDeProcessos().getProcessos();
        Integer totalProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
        Integer threads = looca.getGrupoDeProcessos().getTotalThreads();

        con.execute("DROP TABLE IF EXISTS Processos");

        String criarTabelaProcessos = "CREATE TABLE Processos (\n"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,\n"
                + "ProcessosEmUso int,\n"
                + "totalProcessos int,\n"
                + "threads int\n"
                + ");";

        con.execute(criarTabelaProcessos);

        String inserirDadosProcessos = "Insert into Processos VALUES "
                + "(null,?,?,?);";

        con.update(inserirDadosProcessos, processosEmUso, totalProcessos, threads);
 
        List<LoocaProcessos> loocaProcessos = con.query("select * from Processos",
                new BeanPropertyRowMapper<>(LoocaProcessos.class));

        for (LoocaProcessos processos : loocaProcessos) {

            System.out.println(processos);
        }

        // ------------------------------------------------------------------------- 
            
        
        
        // ------------------------------------------------------------------------- 
        
//        System.out.println("=".repeat(40));
//
//        System.out.println("=".repeat(30));
//        System.out.println(looca.getGrupoDeDiscos());
//
//        System.out.println("=".repeat(30));
//        System.out.println(looca.getGrupoDeProcessos());
//
//        System.out.println("=".repeat(30));
//        System.out.println(looca.getMemoria());
//
//        System.out.println("=".repeat(30));
//        System.out.println(looca.getProcessador());
//
//        System.out.println("=".repeat(30));
//        System.out.println(looca.getTemperatura());

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
