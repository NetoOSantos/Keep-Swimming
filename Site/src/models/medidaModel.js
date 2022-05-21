var database = require("../database/config");

function buscarUltimasMedidas(idMaquina, limite_linhas) {
    idMaquina = 1;
//local
    // instrucaoSql = `select format(sum(usoCPU), 1) from Maquina join processos on idMaquina = fkMaquina where idMaquina = ${idMaquina};`;


//nuvem
    instrucaoSql = `select format(sum(usoCPU), 'N') from Maquina join processos on idMaquina = fkMaquina where idMaquina = ${idMaquina};`;



console.log("Executando a instrução SQL: \n" + instrucaoSql);
return database.executar(instrucaoSql);
    
}

function buscarMedidasEmTempoReal(idMaquina) {

    //local
    // instrucaoSql = `select temperatura_lm35, 
    //                         umidade, 
    //                         DATE_FORMAT(hr_medida,'%H:%i:%s') as momento_grafico, 
    //                         fkMaquina
    //                         from medidas where fkMaquina = ${idMaquina} 
    //                         order by idMedidas desc limit 1`;

//nuvem
    instrucaoSql = `select temperatura_lm35, 
                            umidade, 
                            convert(varchar, getdate(),13) as momento_grafico,
                            fkMaquina
                            from [dbo].[medidas] where fkMaquina = ${idMaquina} 
                            order by hr_medida`;


console.log("Executando a instrução SQL: \n" + instrucaoSql);
return database.executar(instrucaoSql);

}


function buscarMediaConsumoPC(idMaquina) {
// //local
    // instrucaoSql = ` select round( avg(umidade),2) as mediaUmi from medidas ;`;

    //nuvem
    instrucaoSql = ` select round( avg(umidade),2) as mediaUmi from [dbo].[medidas] ;`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}


function buscarConsumoCPU(idMaquina) {
    instrucaoSql = `select usoCPU from [dbo].[Processos] where fkMaquina = 1;`

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}



module.exports = {
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal,
    buscarMediaConsumoPC,
    buscarConsumoCPU,
}