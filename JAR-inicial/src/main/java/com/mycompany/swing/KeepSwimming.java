
package com.mycompany.swing;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class KeepSwimming extends javax.swing.JFrame {
    String EMAIL;
    String SENHA;
   
    public KeepSwimming() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        Onda = new javax.swing.JLabel();
        Barquinho = new javax.swing.JLabel();
        PainelLogin = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        KeepSwimming = new javax.swing.JLabel();
        TextoEmail = new javax.swing.JLabel();
        CampoEmail = new javax.swing.JTextField();
        TextoSenha = new javax.swing.JLabel();
        CampoSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        Resultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fundo.setBackground(new java.awt.Color(37, 28, 94));

        Onda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/OndaRoxaParaCima.png"))); // NOI18N

        Barquinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/feito-removebg-preview.png"))); // NOI18N

        PainelLogin.setBackground(new java.awt.Color(136, 89, 236));
        PainelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PainelLogin.setForeground(new java.awt.Color(136, 89, 236));
        PainelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        KeepSwimming.setForeground(new java.awt.Color(255, 255, 255));
        KeepSwimming.setText("Keep Swimming");

        TextoEmail.setForeground(new java.awt.Color(255, 255, 255));
        TextoEmail.setText("Email");

        CampoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEmailActionPerformed(evt);
            }
        });

        TextoSenha.setForeground(new java.awt.Color(255, 255, 255));
        TextoSenha.setText("Senha");

        CampoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSenhaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Navegar!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLoginLayout = new javax.swing.GroupLayout(PainelLogin);
        PainelLogin.setLayout(PainelLoginLayout);
        PainelLoginLayout.setHorizontalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(Resultado))
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(KeepSwimming))
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(TextoEmail))
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(TextoSenha)))
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CampoEmail)
                    .addComponent(CampoSenha)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );
        PainelLoginLayout.setVerticalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KeepSwimming)
                .addGap(39, 39, 39)
                .addComponent(TextoEmail)
                .addGap(18, 18, 18)
                .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(TextoSenha)
                .addGap(18, 18, 18)
                .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Resultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addComponent(Onda)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(FundoLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(Barquinho, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(PainelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Barquinho, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(PainelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(Onda))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEmailActionPerformed

       
    }//GEN-LAST:event_CampoEmailActionPerformed

    private void CampoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSenhaActionPerformed

        
    }//GEN-LAST:event_CampoSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          //////////////Conexão com o banco//////////////
            
            //Instancia a classe Connection
            //Instancia um objeto Jdbc e pega o retorno getDataSource
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());     
        List funcionario = new ArrayList();
        Funcionario usuario = new Funcionario();
        BeanPropertyRowMapper Bean = new BeanPropertyRowMapper();
            ///////////////////////////////////////////////
            EMAIL = (CampoEmail.getText());
            SENHA = (new String(CampoSenha.getPassword()));
            
     con.execute("DROP TABLE IF EXISTS FUNCIONARIO");
            
     String criarTabelaFuncionario = "CREATE TABLE FUNCIONARIO (ID "
             + "INT PRIMARY KEY AUTO_INCREMENT,"
             + "EMAIL VARCHAR(50),"
             + "SENHA VARCHAR(50));";
     
     con.execute(criarTabelaFuncionario);
     
     String inserirUsuario = "INSERT INTO FUNCIONARIO VALUES (NULL,'bruno','123')";
     con.update(inserirUsuario);
     
     List<Funcionario> Select = con.query("SELECT * FROM FUNCIONARIO",
              new BeanPropertyRowMapper(Funcionario.class));
   
              for (Funcionario func : Select)
              {
                 if(func.getEMAIL().equals(EMAIL) && func.getSENHA().equals(SENHA)) {
                     Resultado.setText("LOGADO COM SUCESSO!");
                 } else {
                 
                     Resultado.setText("=(");
                 }
              }
        
           
             
           

    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
               
               
       /////////////////Padrão do SWING////////////////////////
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeepSwimming().setVisible(true);
            }
        });
        /////////////////////////////////////////////////////////////////
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Barquinho;
    private javax.swing.JTextField CampoEmail;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JPanel Fundo;
    private javax.swing.JLabel KeepSwimming;
    private javax.swing.JLabel Onda;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JLabel Resultado;
    private javax.swing.JLabel TextoEmail;
    private javax.swing.JLabel TextoSenha;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
