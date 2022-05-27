
package com.mycompany.swing;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import static java.nio.file.StandardOpenOption.CREATE;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import static javax.swing.text.html.HTML.Attribute.ID;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaPrincipal extends javax.swing.JFrame {

     public Funcionario funcionario;
    
    public TelaPrincipal(Funcionario idsFuncionario) {
        
        this.funcionario = idsFuncionario;
        
        initComponents();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                inicializacao();
                  
            }
        });
    }
    
    private void inicializacao()
    {
      
        
        // classe de de conexão com o banco
        Connection config = new Connection();

        //conexão com o banco
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        // looca
        com.github.britooo.looca.api.core.Looca looca = new com.github.britooo.looca.api.core.Looca();

        // Insersão dos dados do sistema no banco
        LoocaSistema loocadb = new LoocaSistema();
        
  /////////////////////  Pegando o id da Maquina    ///////////////////////
  
    List<maquina> idMaquina = con.query("select idMaquina from [dbo].[Maquina] \n" +
                            "JOIN [dbo].[FUNCIONARIO] on fkUsuario = idFuncionario \n" +
                            "WHERE idFuncionario = " + funcionario.getIdFuncionario(),
            new BeanPropertyRowMapper(maquina.class));
    
    
    
        System.out.println( "pegando o ID MAQUINA" + idMaquina.toString());
        
        Integer idDaMaquina = idMaquina.get(0).getIdMaquina();
  
  //----------------------------------------------------------------------------
  
       System.out.println("=".repeat(40));
       

        // Listando e inserindo dados do Sistema no banco
       // String sO = looca.getSistema().getSistemaOperacional();
        //String fabricante = looca.getSistema().getFabricante();
        //Integer arquitetura = looca.getSistema().getArquitetura();
        //String permissao = looca.getSistema().getPermissao().toString();
        
        // String inserirDadosMaquina = "Insert into Maquina VALUES "
          //      + "(null,2,?,?,?,?);";
        
        //AZURE
       //  String inserirDadosMaquina = "Insert into Maquina VALUES "
         //       + "(?,?,?,?,?,null);";

        //con.update(inserirDadosMaquina,idMaquina, sO, fabricante, arquitetura, permissao);
        
       // List<LoocaSistema> LoocaSistema = con.query("select * from Maquina",
         //       new BeanPropertyRowMapper<>(LoocaSistema.class));
        
        //loocadb.setsistemaOperacional(sO);
        //loocadb.setfabricante(fabricante);
        //loocadb.setarquitetura(arquitetura);
        //loocadb.setpermissoes(permissao);
        
        //dadosMaquina.setText(loocadb.toString());
        
        
        //for (LoocaSistema sistema : LoocaSistema) {

          //  System.out.println(sistema);
        //}
//------------------------------INSERT DE  PROCESSOS ---------------------------
   
        System.out.println("=".repeat(40));
        Date dataHoraProcesso = new Date();
        
        List<Processo> processos = looca.getGrupoDeProcessos().getProcessos();
       
        
          Timer timer = new Timer();
         Integer delay = 1000;
         Integer interval = 5000;
              
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
          // String inserirDadosProcessos = "Insert into Processos VALUES "
            //   + "(null,1,?,?,?,?,?,?,?,?);";
            
              //Para azure
               String inserirDadosProcessos = "Insert into Processos VALUES "
                + "(?,?,?,?,?,?,?,?,?,?);";
           
           con.update(inserirDadosProcessos,idDaMaquina, PID,Nome,UsoCpu,usoMemoria,
                   bytesUtilizados,memVirtualUtilizada, totalProcessos, threads,dataHoraProcesso);
        }

      }
 },delay,interval);
        
        

        
 

        for (Processo processo : processos) {

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
        //  String inserirDadosHardware = "Insert into ComponentesHardware VALUES" 
          //          + "(null,1,?,?,?,?,?,?);";
                   
         //Para AZURE
           String inserirDadosHardware = "Insert into ComponentesHardware VALUES" 
                    + "(?,?,?,?,?,?,?);";
         
           
           con.update(inserirDadosHardware,
                            idDaMaquina,
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
           //String inserirHistorico = "Insert into Historico VALUES "
             //   + "(null,1,?,?,?,?,?,?,?);";
           
           //AZURE
             String inserirHistorico = "Insert into Historico VALUES "
                + "(?,?,?,?,?,?,?,?);";
           
           con.update(inserirHistorico,idDaMaquina,data,tempoInicializado,tempoDeAtividade,
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        onda = new javax.swing.JLabel();
        logoBarco = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        tituloCapturandoDados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dadosMaquina = new javax.swing.JTextArea();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(null);

        onda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/OndaRoxaParaCima.png"))); // NOI18N
        getContentPane().add(onda);
        onda.setBounds(-120, 460, 1120, 350);

        logoBarco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/feito-removebg-preview.png"))); // NOI18N
        getContentPane().add(logoBarco);
        logoBarco.setBounds(610, 90, 280, 250);

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloCapturandoDados.setBackground(new java.awt.Color(0, 0, 0));
        tituloCapturandoDados.setForeground(new java.awt.Color(0, 0, 0));
        tituloCapturandoDados.setText("Capturando dados da máquina:");

        dadosMaquina.setColumns(20);
        dadosMaquina.setRows(5);
        jScrollPane1.setViewportView(dadosMaquina);

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(tituloCapturandoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addComponent(tituloCapturandoDados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(painelDados);
        painelDados.setBounds(130, 50, 450, 480);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/fundo.png"))); // NOI18N
        getContentPane().add(fundo);
        fundo.setBounds(0, 0, 1000, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
    
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea dadosMaquina;
    private javax.swing.JLabel fundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoBarco;
    private javax.swing.JLabel onda;
    private javax.swing.JPanel painelDados;
    private javax.swing.JLabel tituloCapturandoDados;
    // End of variables declaration//GEN-END:variables
}
