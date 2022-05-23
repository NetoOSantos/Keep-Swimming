
function limparFormulario() {
    document.getElementById("form_cadastro_maquina").reset();
}

function bt_cadastro_maquina(){
    aguardar();    
    
    // Nessa parte ele da um get (Pegar) la no formulario de cadastro pelo id = form_cadastro 
    // e entende que tudo que estiver dentro dessa form e de cadastro 

    var formulario_maquina = new URLSearchParams(new FormData(document.getElementById("form_cadastro_maquina")));

    // Aqui setamos os campos que o usuario vai digitar atraves do campo "name" contido nas inputs
 
    var idmaquina = formulario.get("idmaquina");
    var idfuncionario = formulario.get("idfuncionario");
    var sistemaoperacional = formulario.get("sistemaoperacional");
    var arquitetura = formulario.get("arquitetura");
    var permissao = formulario.get("permissao");
    var fabricante = formulario.get("fabricante");
    var hostname = formulario.get("hostname");



    // TODO: VERIFICAR AS VALIDAÇÕES 
    if (idmaquina == "" || idfuncionario == "" || sistemaoperacional == "" || arquitetura == ""|| permissao == ""|| fabricante == "" ||hostname=="") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (idmaquina == "") {
            console.log('empresa está em branco')
        }
        if (idfuncionario == "") {
            console.log('email está em branco')
        }
        if (sistemaoperacional == "") {
            console.log('senha está em branco')
        }
        if (arquitetura == "") {
            console.log('confirmacaoSenha está em branco')
        }
        if (permissao == "") {
            console.log('confirmacaoEmail está em branco')
        }
        if (perfabricantemissao == "") {
            console.log('CEP está em branco')
        }
        if (hostname == "") {
            console.log('CNPJ está em branco')
        }
        finalizarAguardar();
        return false;
    }

  
    // Se tudo estiver ok ele faz uma busca la na ROUTERS por USUARIOS e o metdodo /CADASTRAR

    fetch("/usuarios/cadastrarMaquina", {
        method: "POST",
        body: formulario_maquina
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            window.location = "cadastro-maquina.html";
            limparFormulario();
            finalizarAguardar();
            
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        finalizarAguardar();
    });

    return false;
}