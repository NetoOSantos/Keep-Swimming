// Faz uma rquisiçao no banco atraves das config dentro da pasta database 
// Sempre verifique se os dados de acesso estao certos

var database = require("../database/config")

// todas as funçoes abaixo fazem uma requisiçao no banco em formato de QUARY e retornam a resposta obitida
// Tendo os dois formatos mais utilizados para teste 
// Sendo MySQL da forma local e Azure com SQLServer de forma remota(nuvem)
//  SEMPREEE que for usar uma das formas NAOO ESQUEÇA de comentar a outra

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    
    // local

    // var instrucao = `
    //     SELECT * FROM empresa;
    // `;


    // azure
    
    var instrucao = `
        SELECT * FROM [dbo].[empresa];
    `;


    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
    
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    
    // local

    // var instrucao = `
    //     SELECT * FROM empresa WHERE email = '${email}' AND senha = '${senha}';
    // `;


    // azure
    var instrucao = `
        SELECT * FROM [dbo].[empresa] WHERE email = '${email}' AND senha = '${senha}';
    `;


    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function cadastrar(nome, email, senha, cnpj, cep) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nome, email, senha, cnpj, cep);
    
    // local
    
    // var instrucao = `
    //     INSERT INTO empresa 
    //     (cnpj,
    //     nome,
    //     email,
    //     cep,
    //     senha) VALUES 
    //     ('${cnpj}', '${nome}', '${email}', '${cep}', '${senha}');
    // `;

    var instrucao = `
        INSERT INTO [dbo].[empresa] 
        (cnpj,
        nome,
        email,
        cep,
        senha) VALUES 
        ('${cnpj}', '${nome}', '${email}', '${cep}', '${senha}');
    `;

    
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
};