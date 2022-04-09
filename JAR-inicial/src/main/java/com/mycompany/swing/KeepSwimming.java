
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
        Barquinho = new javax.swing.JLabel();
        PainelLogin = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        KeepSwimming = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        PainelLoginSenha = new javax.swing.JPanel();
        TextoEmail = new javax.swing.JLabel();
        CampoEmail = new javax.swing.JTextField();
        TextoSenha = new javax.swing.JLabel();
        CampoSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        Onda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fundo.setBackground(new java.awt.Color(37, 28, 94));

        Barquinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/feito-removebg-preview.png"))); // NOI18N

        PainelLogin.setBackground(new java.awt.Color(136, 89, 236));
        PainelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PainelLogin.setForeground(new java.awt.Color(136, 89, 236));
        PainelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        KeepSwimming.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        KeepSwimming.setForeground(new java.awt.Color(255, 255, 255));
        KeepSwimming.setText("Keep Swimming");

        PainelLoginSenha.setBackground(new java.awt.Color(255, 255, 255));
        PainelLoginSenha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PainelLoginSenha.setForeground(new java.awt.Color(255, 255, 255));

        TextoEmail.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TextoEmail.setForeground(new java.awt.Color(0, 0, 0));
        TextoEmail.setText("Email");

        CampoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEmailActionPerformed(evt);
            }
        });

        TextoSenha.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TextoSenha.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout PainelLoginSenhaLayout = new javax.swing.GroupLayout(PainelLoginSenha);
        PainelLoginSenha.setLayout(PainelLoginSenhaLayout);
        PainelLoginSenhaLayout.setHorizontalGroup(
            PainelLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginSenhaLayout.createSequentialGroup()
                .addGroup(PainelLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLoginSenhaLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(TextoEmail))
                    .addGroup(PainelLoginSenhaLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(TextoSenha))
                    .addGroup(PainelLoginSenhaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(PainelLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PainelLoginSenhaLayout.setVerticalGroup(
            PainelLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginSenhaLayout.createSequentialGroup()
                .addComponent(TextoEmail)
                .addGap(27, 27, 27)
                .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(TextoSenha)
                .addGap(18, 18, 18)
                .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelLoginLayout = new javax.swing.GroupLayout(PainelLogin);
        PainelLogin.setLayout(PainelLoginLayout);
        PainelLoginLayout.setHorizontalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(1160, 1160, 1160)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(Resultado))
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(KeepSwimming))
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(PainelLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelLoginLayout.setVerticalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(KeepSwimming)
                .addGap(27, 27, 27)
                .addComponent(PainelLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Resultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        Onda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/OndaRoxaParaCima.png"))); // NOI18N

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(Barquinho, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Onda, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(Barquinho, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(Onda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PainelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JPanel PainelLoginSenha;
    private javax.swing.JLabel Resultado;
    private javax.swing.JLabel TextoEmail;
    private javax.swing.JLabel TextoSenha;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
