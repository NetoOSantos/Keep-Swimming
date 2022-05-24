
package com.mycompany.swing;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class alertaParaTelegram {
    
    private Long mediaMemoria;
    
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    
    public Long getMedia()
    {        
         List<mediaMemoria> comandoMedia = con.query(
                 "select round(avg(memoriaEmUso),0) AS mediaMemoria from [dbo].[Historico]",
            new BeanPropertyRowMapper(mediaMemoria.class));
        
       // List<mediaMemoria> comandoMedia = con.query(
         //        "select memoriaEmUso AS mediaMemoria from [dbo].[Historico]",
           // new BeanPropertyRowMapper(mediaMemoria.class));
        
        
       for(mediaMemoria media : comandoMedia)
       {
           mediaMemoria = media.getMediaMemoria();
       }
       
       
            return mediaMemoria;
    }
     
  //  public Funcionario getDadosFuncionario(Integer idFuncionario)
    //{
      //  List<dadosFuncionarioOcioso> select = con.query(
          //       "",
        //    new BeanPropertyRowMapper(mediaMemoria.class));
    //}
   
//select idFuncionario,Nome,cargo, memoriaEmUso from [dbo].[FUNCIONARIO] join [dbo].[Maquina]
 // idFuncionario = fkUsuario join [dbo].[Historico] on idMaquina = fkMaquina
}
