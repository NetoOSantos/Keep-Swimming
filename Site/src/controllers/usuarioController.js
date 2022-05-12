var usuarioModel = require("../models/usuarioModel");

var sessoes = [];

function testar (req, res) {
    console.log("ENTRAMOS NA usuarioController");
    res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
    usuarioModel.listar()
    .then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(
        function (erro) {
            console.log(erro);
            console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
            res.status(500).json(erro.sqlMessage);
        }
    );
}

function entrar (req, res) {
    var email = req.body.emailServer;
    var senha = req.body.senhaServer;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        usuarioModel.entrar(email, senha)
        .then(
            function (resultado) {
                console.log(`\nResultados encontrados: ${resultado.length}`);
                console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                if (resultado.length == 1) {
                    console.log(resultado);
                    res.json(resultado[0]);
                } else if (resultado.length == 0) {
                    res.status(403).send("Email e/ou senha inválido(s)");
                } else {
                    res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                }
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
    }

}

function cadastrar(req, res) {
    var nome = req.body.nomeServer;
    var email = req.body.emailServer;
    var senha = req.body.senhaServer;
    var CNPJ = req.body.cnpjServer;
    var cep = req.body.cepServer;

    console.log("req.body bananinha");
    console.log(req.body);

    if (nome == undefined) {
        res.status(400).send("Seu nome da empresa está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else if (CNPJ == undefined) {
        res.status(400).send("Seu CNPJ está undefined!");
    } else if (cep == undefined) {
        res.status(400).send("Seu CEP está undefined!");
    } else {
        usuarioModel.cadastrar(nome, email, senha, CNPJ, cep)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao realizar o cadastro! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );
    }
}

function cadastrarFuncionario(req, res) {
    var nome = req.body.nomeServer;
    var email = req.body.emailServer;
    var gestor = req.body.gestorServer;
    var cargo = req.body.cargoServer;
    var senha = req.body.senhaServer;
    var idEmpresa = req.body.idEmpresa;


    console.log("req.body cadastro funcionário");
    console.log(req.body);

    if (nome == undefined) {
        res.status(400).send("O nome do funcionário está undefined!");
    } else if (email == undefined) {
        res.status(400).send("O email do funcionário está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("A senha do funcionário está undefined!");
    } else if (gestor == undefined) {
        res.status(400).send("Campo gestor está undefined!");
    } else if (cargo == undefined) {
        res.status(400).send("Campo cargo está undefined!");
    } else {
        usuarioModel.buscarIdGestor(gestor).then(
            function (resultadoGestor) {
                console.log(resultadoGestor);
                    resultadoGestor.JSON;
                    JSON.stringify(resultadoGestor);
                    var gestor = resultadoGestor[0];
                usuarioModel.cadastrarFuncionario(nome, email,senha,cargo,idEmpresa, gestor.idFuncionario)
                .then(
                    function (resultado) {
                        res.json(resultado);
                    }
                ).catch(
                    function (erro) {
                        console.log(erro);
                        console.log(
                            "\nHouve um erro ao realizar o cadastro! Erro: ",
                            erro.sqlMessage
                        );
                        res.status(500).json(erro.sqlMessage);
                    }
                );
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao realizar o cadastro! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );
    }
}

function deletarFuncionario(req, res) {
    var idFuncionario = req.body.idDelete;
 


    console.log("req.body delete funcionário");
    console.log(req.body);

    if (idFuncionario == undefined) {
        res.status(400).send("O id do funcionário está undefined!");
    } else {
        usuarioModel.deletarFuncionario(idFuncionario)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao realizar o delete! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );
    }
}


function updateFuncionario(req, res) {
    var idFuncionario = req.body.idUpdate;
    var alteraçãoFuncionario = req.body.alteracao;
    var  update = req.body.updateEscolhido;
 


    console.log("req.body Update funcionário");
    console.log(req.body);

    if (idFuncionario == undefined) {
        res.status(400).send("O id do funcionário está undefined!");
    } else if(alteraçãoFuncionario == undefined){
        res.status(400).send("A input para alteração do funcionário está undefined!");
    } else if(update == undefined){
        res.status(400).send("A select para alteração do funcionário está undefined!");
   
    }else {
        usuarioModel.updateFuncionario(idFuncionario,alteraçãoFuncionario,update)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao realizar o update! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );
    }
}

module.exports = {
    entrar,
    cadastrar,
    cadastrarFuncionario,
    deletarFuncionario,
    updateFuncionario,
    listar,   
    testar
}