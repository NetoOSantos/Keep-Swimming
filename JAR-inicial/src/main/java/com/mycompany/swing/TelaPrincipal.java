
package com.mycompany.swing;

import com.github.britooo.looca.api.group.processos.Processo;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaPrincipal extends javax.swing.JFrame {

    
    public TelaPrincipal() {
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
        
       
  //----------------------------------------------------------------------------
  
       System.out.println("=".repeat(40));

        // Listando e inserindo dados do Sistema no banco
        String sO = looca.getSistema().getSistemaOperacional();
        String fabricante = looca.getSistema().getFabricante();
        Integer arquitetura = looca.getSistema().getArquitetura();
        String permissao = looca.getSistema().getPermissao().toString();
        
           String criarTabelaMaquina= "CREATE TABLE IF NOT EXISTS Maquina (\n"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,\n"
                + "sistemaOperacional varchar(50),\n"
                + "fabricante varchar(50),\n"
                + "arquitetura int,\n"
                + "permissoes varchar(50)\n"
                + ");";

        con.execute(criarTabelaMaquina);
        
         String inserirDadosMaquina = "Insert into Maquina VALUES "
                + "(null,?,?,?,?);";

        con.update(inserirDadosMaquina, sO, fabricante, arquitetura, permissao);
        
        List<LoocaSistema> LoocaSistema = con.query("select * from Maquina",
                new BeanPropertyRowMapper<>(LoocaSistema.class));
        
        loocadb.setsistemaOperacional(sO);
        loocadb.setfabricante(fabricante);
        loocadb.setarquitetura(arquitetura);
        loocadb.setpermissoes(permissao);
        
        dadosMaquina.setText(loocadb.toString());
        
        
        for (LoocaSistema sistema : LoocaSistema) {

            System.out.println(sistema);
        }

        
        
        
       
        
////////////////////////////////////////////////////////////////////////////////  

    
//------------------------------INSERT DE  PROCESSOS ---------------------------
   
        System.out.println("=".repeat(40));
        
        List<Processo> processos = looca.getGrupoDeProcessos().getProcessos();
        

        con.execute("DROP TABLE IF EXISTS Processos");

        String criarTabelaProcessos = "CREATE TABLE Processos (\n"
                + "PID INT PRIMARY KEY,\n"
                + "Nome varchar(45),\n"
                + "usoCPU DOUBLE,\n"
                + "usoMemoria DOUBLE,\n"
                + "bytesUtilizados INT,\n"
                + "memVirtualUtilizada DOUBLE,\n"
                + "totalProcessos int,\n"
                + "threads int\n"
                + ");";

        con.execute(criarTabelaProcessos);
        
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
           
           String inserirDadosProcessos = "Insert into Processos VALUES "
                + "(?,?,?,?,?,?,?,?);";
           
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
