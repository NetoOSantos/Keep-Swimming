package com.mycompany.swing;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaPrincipalsemI {
    
    
    public void inicializacao()
    {
          // classe de de conexão com o banco
        Connection config = new Connection();

        //conexão com o banco
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        // looca
        com.github.britooo.looca.api.core.Looca looca = new com.github.britooo.looca.api.core.Looca();

        // Insersão dos dados do sistema no banco
        LoocaSistema loocadb = new LoocaSistema();
        
       
  //----------------------------------------------------------------------------
  
       System.out.println("=".repeat(40));

        // Listando e inserindo dados do Sistema no banco
        String sO = looca.getSistema().getSistemaOperacional();
        String fabricante = looca.getSistema().getFabricante();
        Integer arquitetura = looca.getSistema().getArquitetura();
        String permissao = looca.getSistema().getPermissao().toString();
        
//         String inserirDadosMaquina = "Insert into Maquina VALUES "
//                + "(null,2,?,?,?,?);";
        
        //AZURE
         String inserirDadosMaquina = "Insert into Maquina VALUES "
                + "(null,?,?,?,?,null);";

        con.update(inserirDadosMaquina, sO, fabricante, arquitetura, permissao);
        
        List<LoocaSistema> LoocaSistema = con.query("select * from Maquina",
                new BeanPropertyRowMapper<>(LoocaSistema.class));
        
        loocadb.setsistemaOperacional(sO);
        loocadb.setfabricante(fabricante);
        loocadb.setarquitetura(arquitetura);
        loocadb.setpermissoes(permissao);
        
  
        
        
        for (LoocaSistema sistema : LoocaSistema) {

            System.out.println(sistema);
        }
//------------------------------INSERT DE  PROCESSOS ---------------------------
   
        System.out.println("=".repeat(40));
        
        List<Processo> processos = looca.getGrupoDeProcessos().getProcessos();
       
        
          Timer timer = new Timer();
         Integer delay = 1000;
         Integer interval = 10000;
              
        timer.scheduleAtFixedRate(new TimerTask() {
             @Override
             public void run() {
                 
             
        for(int i = 0; i < processos.size(); i++)
        {
           Integer PID = processos.get(i).getPid();
           String Nome = processos.get(i).getNome();
           Double UsoCpu = processos.get(i).getUsoCpu();
           Double usoMemoria = processos.get(i).getUsoMemoria();
           Long bytesUtilizados = processos.get(i).getBytesUtilizados();
           Long memVirtualUtilizada = processos.get(i).getMemoriaVirtualUtilizada();        
           Integer totalProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
           Integer threads = looca.getGrupoDeProcessos().getTotalThreads();
           //para Mysql local
//           String inserirDadosProcessos = "Insert into Processos VALUES "
//               + "(null,1,?,?,?,?,?,?,?,?);";
             
              //Para azure
               String inserirDadosProcessos = "Insert into Processos VALUES "
                + "(1,?,?,?,?,?,?,?,?);";
           
           con.update(inserirDadosProcessos, PID,Nome,UsoCpu,usoMemoria,
                   bytesUtilizados,memVirtualUtilizada, totalProcessos, threads);
        }

      }
 },delay,interval);

        
 
        List<LoocaProcessos> processosSelect = con.query("select * from Processos",
                new BeanPropertyRowMapper<>(LoocaProcessos.class));

        for (LoocaProcessos processo : processosSelect) {

            System.out.println(processo);
        }

        // ------------------------------------------------------------------------- 
          
//----------------------------INSERT COMPONENTES HARDWARE----------------------
    
     
        
        DiscosGroup disco = new DiscosGroup();
        Memoria memoria = new Memoria();
        Processador processador = new Processador();
        
         List<Disco> listaDeDisco = disco.getDiscos();
       
         
         
           for (int i = 0; i < listaDeDisco.size(); i++) {
            
             String nomeDisco = disco.getDiscos().get(i).getNome();
             Long tamanhoDisco = disco.getDiscos().get(i).getTamanho();
             String modeloDisco = disco.getDiscos().get(i).getModelo();
             Integer qtdDiscos = disco.getQuantidadeDeDiscos();
             Long memoriaTotal = memoria.getTotal();
             String processadorNome = processador.getNome();
             
              //Para Mysql local
//          String inserirDadosHardware = "Insert into ComponentesHardware VALUES" 
//                    + "(null,1,?,?,?,?,?,?);";
                   
         //Para AZURE
           String inserirDadosHardware = "Insert into ComponentesHardware VALUES" 
                    + "(1,?,?,?,?,?,?);";
         
           
           con.update(inserirDadosHardware,
                            nomeDisco,
                            tamanhoDisco,
                            modeloDisco,
                            qtdDiscos, 
                            memoriaTotal,
                            processadorNome);
           
             System.out.println("nome do disco: " + nomeDisco);
             System.out.println("tamanho do disco: " + tamanhoDisco);
             System.out.println("modelo do disco: " + modeloDisco);
             System.out.println("Quantidade de discos"  + qtdDiscos);
             System.out.println("Memoria total"  + memoriaTotal);
             System.out.println("Nome processador"  + processadorNome);
        }
         

//-------------------------------INSERT HISTORICO------------------------------
        Date data = new Date();

       // LocalDateTime data = LocalDateTime.now();
        
        String tempoInicializado = looca.getSistema().getInicializado().toString();
        String tempoDeAtividade = looca.getSistema().getTempoDeAtividade().toString();
        String temperaturaAtual = looca.getTemperatura().toString();
        Long memoriaEmUso = memoria.getEmUso();
        Long memoriaDisponível = memoria.getDisponivel();
        Double processadorUso = processador.getUso();
        
   
        
          timer.scheduleAtFixedRate(new TimerTask() {
             @Override
             public void run() {
           //MySQL local         
//           String inserirHistorico = "Insert into Historico VALUES "
//                + "(null,1,?,?,?,?,?,?,?);";
           
           //AZURE
             String inserirHistorico = "Insert into Historico VALUES "
                + "(1,?,?,?,?,?,?,?);";
           
           con.update(inserirHistorico,data,tempoInicializado,tempoDeAtividade,
                   temperaturaAtual,memoriaEmUso,memoriaDisponível,processadorUso);
           
           System.out.println("Data "  + data);
           System.out.println("Tempo inicializado "  + tempoInicializado);
           System.out.println("Tempo de atividade "  + tempoDeAtividade);
           System.out.println("Temperatura atual "  + temperaturaAtual);
           System.out.println("Memoria em uso "  + memoriaEmUso);
           System.out.println("Memoria disponível "  + memoriaDisponível);
           System.out.println("Uso do processador "  + processadorUso);
        

      }
 },delay,interval);
    
    }
}
