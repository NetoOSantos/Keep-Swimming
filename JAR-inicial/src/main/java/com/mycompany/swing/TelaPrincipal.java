
package com.mycompany.swing;

import java.util.List;
import java.util.logging.Level;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaPrincipal extends javax.swing.JFrame {

    
    public TelaPrincipal() {
        initComponents();
        inicializacao();
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
        
  //////////////////////////////////////////////////////////////////////////////
  
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
                        .addComponent(tituloCapturandoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addComponent(tituloCapturandoDados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(painelDados);
        painelDados.setBounds(130, 50, 450, 480);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/fundo.png"))); // NOI18N
        getContentPane().add(fundo);
        fundo.setBounds(0, 0, 1000, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
    
           
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
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
