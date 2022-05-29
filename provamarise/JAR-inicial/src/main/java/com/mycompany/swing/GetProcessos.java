
package com.mycompany.swing;

import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class GetProcessos {
    
    public static void main(String[] args) {
        
        // Listando e inserindo dados dos processos no banco
        
         Timer timer = new Timer();
         Integer delay = 1000;
         Integer interval = 10000;
    
        
        timer.scheduleAtFixedRate(new TimerTask() {
             @Override
             public void run() {
                 
        ProcessosGroup processos = new ProcessosGroup();
        
        LoocaProcessos processosBD = new LoocaProcessos();
        
        List<Processo> listaProcessos = processos.getProcessos();
        
        Connection con = new Connection();
        
        JdbcTemplate template = new JdbcTemplate(con.getDatasource());
        
        String criarTabelaProcessos = "CREATE TABLE IF NOT EXISTS Processos (\n"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,\n"
                + "Nome varchar(100),\n"
                + "UsoCPU double,\n"
                + "UsoMemoria double,\n"
                + "BytesUtilizados int,\n"
                + "MemVirtual decimal,\n"
                + "PID int,\n"
                + "totalProcessos int,\n"
                + "threads int\n"
                + ");";
        
        
        for (int i = 0; i < listaProcessos.size(); i++) {
            
            String nome = processos.getProcessos().get(i).getNome();
            Double usoCPU = processos.getProcessos().get(i).getUsoCpu();
            Double usoMem = processos.getProcessos().get(i).getUsoMemoria();
            Long bytesUtilizados = processos.getProcessos().get(i).getBytesUtilizados();
            Long memVirtual = processos.getProcessos().get(i).getMemoriaVirtualUtilizada();
            Integer pid = processos.getProcessos().get(i).getPid();          
            Integer totalProcessos = processos.getTotalProcessos();
            Integer threads = processos.getTotalThreads();
            
            String inserirDadosProcessos = "Insert into Processos VALUES "
                    + "(null,?,?,?,?,?,?,?,?);";

            template.update(inserirDadosProcessos, 
                            nome,
                            usoCPU,
                            usoMem,
                            bytesUtilizados,
                            memVirtual,
                            pid,
                            totalProcessos, 
                            threads);
            
        }
        
          List<LoocaProcessos> loocaProcessos = template.query("select * from Processos",
                new BeanPropertyRowMapper<>(LoocaProcessos.class));

        for (LoocaProcessos processos1 : loocaProcessos) {

            System.out.println(processos);
            System.out.println("-".repeat(50));
        }
             }
        }, delay, interval);
         
    }
    
}
