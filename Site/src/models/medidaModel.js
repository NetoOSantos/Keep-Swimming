var database = require("../database/config");

function buscarUltimasMedidas(idMaquina, limite_linhas) {
    

//nuvem
  //  instrucaoSql = `select distinct top ${limite_linhas} 
    //                    round(memoriaEmUso, 0) AS dadosMemoria,
      //                  round(processadorUso,2) AS dadosProcessador,
        //                convert(varchar,data,13) AS Hora
          //        from Maquina join [dbo].[Historico] on idMaquina = fkMaquina where idMaquina = ${idMaquina} order by Hora desc`;

          instrucaoSql = `select distinct top ${limite_linhas}
		
          round(memoriaEmUso,1) AS dadosMemoria,
          round(processadorUso,0) AS dadosProcessador,
          convert(varchar,data,13) AS Hora,
          round(memoriaDisponivel,0) as memoriaDisponivel,
          round(memoriaTotal,0) as memoriaTotal
     
                  from Maquina join [dbo].[Historico] on idMaquina = Historico.fkMaquina 
                  join [dbo].[ComponentesHardware] on idMaquina = ComponentesHardware.fkMaquina
                  where idMaquina = ${idMaquina}
                  order by Hora desc`;

console.log("Executando a instrução SQL: \n" + instrucaoSql);
return database.executar(instrucaoSql);
    
}


function buscarMedidasEmTempoReal(idMaquina,componenteSelecionado) {


//nuvem
   

     //   instrucaoSql = `select top 1
       //                     round(memoriaEmUso, 0) AS dadosMemoria,
         //                   round(processadorUso,2) AS dadosProcessador,
           //                 convert(varchar,data,13) AS Hora,
             //               round(memoriaDisponivel,0) as memoriaDisponivel
               //         from Maquina join [dbo].[Historico] on idMaquina = fkMaquina where idMaquina = ${idMaquina} order by Hora desc`;
  
    instrucaoSql = `select distinct top 1
		
    round(memoriaEmUso,1) AS dadosMemoria,
    round(processadorUso,0) AS dadosProcessador,
    convert(varchar,data,13) AS Hora,
    round(memoriaDisponivel,0) as memoriaDisponivel,
    round(memoriaTotal,0) as memoriaTotal
            from Maquina join [dbo].[Historico] on idMaquina = Historico.fkMaquina 
            join [dbo].[ComponentesHardware] on idMaquina = ComponentesHardware.fkMaquina
            where idMaquina = 1
            order by Hora desc`;

console.log("Executando a instrução SQL: \n" + instrucaoSql );
return database.executar(instrucaoSql);

}


module.exports = {
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal,

}