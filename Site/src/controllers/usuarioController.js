var usuarioModel = require("../models/usuarioModel");

var sessoes = [];

// Funçao de teste ao iniciar 

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

// Metodo entrar

// Faz uma requisiço e retorna uma resposta
function entrar (req, res) {

    // Variaveris que serao procuradas no banco
    var email = req.body.email;
    var senha = req.body.senha;

    // Validaçoes
    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        // Busca atravez da MODEL no banco de dados passando dois parametros (podem ser mais)
        usuarioModel.entrar(email, senha)
        .then(
            // Faz a requisiçao e retorna em jason e verifica o tamanho do
            function (resultado) {
                console.log(`\nResultados encontrados: ${resultado.length}`);
                console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String


                // Se alguma dos dois parametros der erro
                if (resultado.length == 1) {
                    console.log(resultado);
                    res.json(resultado[0]);
                } else if (resultado.length == 0) {
                    res.status(403).send("Email e/ou senha inválido(s)");
                } else {
                    res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                }
            }

            // Se nao der certo ao acessar o banco retorna erro
        ).catch(
            function (erro) {
                console.log(erro);
                console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
    }

}

// Metodo cadastrar

// Faz uma requisiço e retorna uma resposta
function cadastrar(req, res) {

    // Variaveris que serao inseridas no banco
    // requisaço vinda do body com o um dos names abaixo

    var empresa = req.body.empresa;
    var email = req.body.email;
    var senha = req.body.senha;
    var cnpj = req.body.cnpj;
    var cep = req.body.cep;

    console.log(req.body);
    console.log(empresa,email,senha,cnpj,cep);

    // Validaçoes caso algum campo venha vazio
    if (empresa == undefined) {
        res.status(400).send("Seu empresa da empresa está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else if (cnpj == undefined) {
        res.status(400).send("Seu CNPJ está undefined!");
    } else if (cep == undefined) {
        res.status(400).send("Seu CEP está undefined!");
    } else {
        // Se tudo estiver ok
        // Faz uma requisiçao passando os parametros abaixo dentro da model
        usuarioModel.cadastrar(empresa, email, senha, cnpj, cep)
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

function cadastrarMaquina(req, res) {


    var hostName = req.body.hostNameServer
    var idMaquina = req.body.idMaquinaServer;
    var idFuncionario = req.body.idFuncionarioServer;
    var sistemaOperacional = req.body.sistemaOperacionalServer;
    var arquitetura = req.body.arquiteturaServer;
    var permissao = req.body.permissao;
    var fabricante = req.body.fabricante


    console.log("req.body cadastro funcionário");
    console.log(req.body);

    if (hostName == undefined) {
        res.status(400).send("O hostName do funcionário está undefined!");
    } else if (idMaquina == undefined) {
        res.status(400).send("O idMaquina da máquina está undefined!");
    } else if (idFuncionario == undefined) {
        res.status(400).send("A o id do funcionário está undefined!");
    } else if (sistemaOperacional == undefined) {
        res.status(400).send("Campo sistema operacional está undefined!");
    } else if (arquitetura == undefined) {
        res.status(400).send("Campo de arquitetura está undefined!");
    }else if (permissao == undefined) {
        res.status(400).send("Campo de permissão inválido")
    }else if (fabricante == undefined) {
        resres.status(400).send("Campo de fabricante inválido")
    } else {
        usuarioModel.buscarIdFuncionario(hostName).then(
            function (resultadoFuncionario) {
                console.log(resultadoFuncionario);
                    resultadoFuncionario.JSON;
                    JSON.stringify(resultadoFuncionario);
                    var idFuncionario = resultadoFuncionario[0];
                usuarioModel.cadastrarMaquina(idMaquina, idFuncionario, sistemaOperacional, arquitetura, permissao,hostName)
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
                    "\nHouve um erro ao realizar o cadastro da máquina! Erro: ",
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
    cadastrarMaquina,
    listar,   
    testar
}