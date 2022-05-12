var database = require("../database/config")

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM funcionario;
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
    
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM empresa WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function cadastrar(nome, email, senha, cnpj, cep) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nome, email, senha, cnpj, cep);
    
    var instrucao = `
        INSERT INTO empresa (cnpj, nome, email, cep, senha) VALUES ('${cnpj}', '${nome}', '${email}', '${cep}', '${senha}');
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function buscarIdGestor(nome)
{
    console.log("Buscando id gestor pelo nome");

    var instrucao = `SELECT idFuncionario FROM FUNCIONARIO WHERE Nome = '${nome}';`;
    return database.executar(instrucao);
}

function cadastrarFuncionario(nome, email, senha, cargo,idEmpresa, idGestor) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarFuncionario():",nome, email,cargo, senha,idEmpresa,idGestor);

    var instrucao = `       
        INSERT INTO FUNCIONARIO  VALUES (null,${idGestor},${idEmpresa}, '${nome}', '${email}', '${senha}', '${cargo}');
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);

}

function deletarFuncionario(idFuncionario) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function deletarFuncionario():");
    
    var instrucao = `
        DELETE FROM FUNCIONARIO WHERE idFuncionario = ${idFuncionario};
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function updateFuncionario(idFuncionario,alteracao,coluna) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function updateFuncionario():");

    var instrucao;

    if(coluna == "id")
    {
        instrucao = `update fUNCIONARIO SET idFuncionario = ${alteracao} Where idFuncionario = ${idFuncionario};`;
    } 
    else if(coluna == "nome")
    {
         instrucao = `update fUNCIONARIO SET Nome = '${alteracao}' Where idFuncionario = ${idFuncionario};`;
    }   
    else if(coluna == "email")
    {
         instrucao = `update fUNCIONARIO SET EMAIL = '${alteracao}' Where idFuncionario = ${idFuncionario};`;
    }
    else if(coluna == "cargo")
    {
         instrucao = `update fUNCIONARIO SET Cargo = '${alteracao}' Where idFuncionario = ${idFuncionario};`;
    }
    
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    cadastrarFuncionario,
    deletarFuncionario,
    updateFuncionario,
    listar,
    buscarIdGestor,
};