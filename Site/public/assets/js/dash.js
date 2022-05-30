
    var email = sessionStorage.EMAIL_USUARIO;
    var responsavel = sessionStorage.responsavel_USUARIO;
    var id = sessionStorage.ID_EMPRESA;

    // sp_empresa.innerHTML = razaoEmp;
    // sp_resp.innerHTML = responsavel;
    let proximaAtualizacao;
    var gradient;

    //verificar_autenticacao();

    // altere aqui como os dados serão exibidos
    // e como são recuperados do BackEnd
    function obterDadosGrafico() {
        if (proximaAtualizacao != undefined) {
            clearTimeout(proximaAtualizacao);
        }

        fetch(`/medidasdash/ultimas/`, { cache: 'no-store' }).then(function (response) {
            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log("Dados recebidos!");
                    // console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    resposta.reverse();

                    plotarGrafico(resposta);
                    

                });
            } else {
                console.error('Nenhum dado encontrado ou erro na API');
            }
        })
            .catch(function (error) {
                console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
            });

    }

   
    function plotarGrafico(resposta) {
        console.log('iniciando plotagem do gráfico...');
        // console.log('deucertpo');


        
        var dados = {
            labels: ['VsCode', 'NetBens'],
            datasets: [
                {
                    label:'usoCpu',
                    data: [],
                    backgroundColor: [],
                    borderColor: [],
                    borderWidth: 1
                },
                {
                    label: 'usoRam',
                    data: [],
                    backgroundColor: [],
                    borderColor: [],
                    borderWidth: 1
                }
            ]
        };
        
        dados.datasets[0].borderColor = 'rgba(167, 121, 232, 1)';
        dados.datasets[1].borderColor = 'rgb(236, 65, 102,1)';
        dados.datasets[1].backgroundColor = 'rgba(79, 92, 196, 1)';
        dados.datasets[0].backgroundColor = 'rgba(79, 92, 196, 1)';
       
        for (i = 0; i < resposta.length; i++) {
            var registro = resposta[i];

            // console.log("registro");
            // console.log(registro);

            
            // var vsCode = registro.nome.opera;
            // var netBens = registro.nome.AvastUI;

            // console.log("registro labels");
            // dados.labels.push(registro.vsCode);
            // dados.labels.push(registro.netBens);
            // console.log(registro.vsCode,registro.netBens);


            // console.log("registro valores");
            // console.log(registro.usoCPU);
            dados.datasets[0].data.push(registro.UsoCPU);
            dados.datasets[1].data.push(registro.UsoMemoria);
            
        }

        // console.log(JSON.stringify(dados));

       
        
        var ctx = chartBar.getContext('2d');
        window.grafico_barra = new Chart(ctx, {
            type: 'bar',
            data: dados,
               //Configurações do gráfico
            options: {
                animation: false,
                title: {
                    display: true,
                    text: 'Comparação de processamento por uso de Ides'},
                plugins: {  // 'legend' now within object 'plugins {}'
                    legend: {
                        labels: {
                            color: "white",  // not 'fontColor:' anymore
                            // fontSize: 18  // not 'fontSize:' anymore
                            font: {
                                size: 14 // 'size' now within object 'font {}'
                            }
                        }
                    }
                },
                scales: {
                    y: {
                        ticks: {
                            color: 'white'
                        },
                        beginAtZero: true
                    },
                    x: {
                        ticks: {
                            color: 'white'
                        },
                        beginAtZero: true
                    },
                }
            }
        });


        


        //Atualiza os dados de 2 em 2 segundos
        setTimeout(() => atualizarGrafico(dados), 2000);
    }

    // só mexer se quiser alterar o tempo de atualização
    // ou se souber o que está fazendo!
    function atualizarGrafico(dados) {
        fetch(`/medidasdash/tempo-real/`, { cache: 'no-store' }).then(function (response) {
            if (response.ok) {
                response.json().then(function (novoRegistro) {

                    console.log("Dados recebidos!");
                    // console.log(`Dados recebidos: ${JSON.stringify(novoRegistro)}`);
                    // console.log(`Dados atuais do gráfico: ${dados}`);

                    // tirando e colocando valores no gráfico
                    // dados.labels.shift(); // apagar o primeiro
                    // dados.labels.push(novoRegistro[0].momento_grafico); // incluir um novo momento
                    dados.datasets[0].data.shift();  // apagar o primeiro de Maquina
                    dados.datasets[1].data.shift();  // apagar o primeiro de Maquina


                    // dados.datasets[0].data.push(novoRegistro[0].Maquina); // incluir uma nova medida de Maquina
                    dados.datasets[0].data.push(novoRegistro[0].UsoCPU);
                    dados.datasets[1].data.push(novoRegistro[1].UsoMemoria);

                    // Alertas por Cores de Maquina

                    // if (novoRegistro[0].Maquina >= 35) {
                    //     img_alertas_umi.src = "../assets/errado_gif.gif"
                    //     dados.datasets[0].borderColor = 'red';
                    //     dados.datasets[0].backgroundColor = '#ff04008c';
                    // } else if (novoRegistro[0].Maquina <= 19) {
                    //     img_alertas_umi.src = "../assets/errado_gif.gif"
                    //     dados.datasets[0].borderColor = '#483D8B';
                    //     dados.datasets[0].backgroundColor = '#826fff9c';

                    // } else if ((novoRegistro[0].Maquina >= 20 && novoRegistro[0].Maquina <= 23) || novoRegistro[0].Maquina >= 28 && novoRegistro[0].Maquina <= 31) {
                    //     img_alertas_umi.src = "../assets/atencao_gif.gif"
                    //     dados.datasets[0].borderColor = '#FFFF00';
                    //     dados.datasets[0].backgroundColor = '#ffe6006b';
                    // } else if (novoRegistro[0].Maquina > 23 && novoRegistro[0].Maquina < 28) {
                    //     dados.datasets[0].borderColor = '#32B9CD';
                    //     dados.datasets[0].backgroundColor = '#32b9cd8f';
                    //     img_alertas_umi.src = "../assets/correto_gif.gif"
                    // }


                    window.grafico_barra.update();

                    proximaAtualizacao = setTimeout(() => atualizarGrafico(dados), 5000);
                });
            } else {
                console.error('Nenhum dado encontrado ou erro na API');
                proximaAtualizacao = setTimeout(() => atualizarGrafico(dados), 5000);
            }
        })
            .catch(function (error) {
                console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
            });

    }

    function atualizarFeed() {
        aguardar();
        fetch("/avisos/listar").then(function (resposta) {
            if (resposta.ok) {
                if (resposta.status == 204) {
                    var feed = document.getElementById("feed_container");
                    var mensagem = document.createElement("span");
                    mensagem.innerHTML = "Nenhum resultado encontrado."
                    feed.appendChild(mensagem);
                    throw "Nenhum resultado encontrado!!";
                }

                resposta.json().then(function (resposta) {
                    console.log("Dados recebidos: ", JSON.stringify(resposta));

                    var feed = document.getElementById("feed_container");
                    feed.innerHTML = "";
                    for (var i = 0; i < resposta.length; i++) {
                        var publicacao = resposta[i];

                        // criando e manipulando elementos do HTML via JavaScript
                        var divPublicacao = document.createElement("div");
                        var spanID = document.createElement("span");
                        var spanTitulo = document.createElement("span");
                        var spanNome = document.createElement("span");
                        var usodacpu = document.createElement("div");
                        var usodaMemoria = document.createElement("div");

                        spanID.innerHTML = "IDMaquina: <b>" + publicacao.idMaquina + "</b>";
                        spanTitulo.innerHTML = "Nome do Processo: ";
                        spanNome.innerHTML = "<b>"+publicacao.Nome+"</b>";
                        usodacpu.innerHTML = "Uso da cpu: <b>"+publicacao.usoCPU+"</b>";
                        usodaMemoria.innerHTML = "Uso da Memoria: <b>"+publicacao.usoMemoria+"</b>";

                        divPublicacao.className = "publicacao";
                        spanTitulo.id = "inputNumero"+publicacao.idMaquina;
                        spanNome.className = "publicacao-nome";
                        spanTitulo.className = "publicacao-titulo";
                        usodacpu.className = "publicacao-descricao";
                        usodaMemoria.className = "publicacao-descricao";

                        // divButtons.className = "div-buttons"

                        divPublicacao.appendChild(spanID);
                        divPublicacao.appendChild(spanTitulo);
                        divPublicacao.appendChild(spanNome);
                        divPublicacao.appendChild(usodacpu);
                        divPublicacao.appendChild(usodaMemoria);
                        feed.appendChild(divPublicacao);
                    }

                    finalizarAguardar();
                });
            } else {
                throw('Houve um erro na API!');
            }
        }).catch(function(resposta) {
            console.error(resposta);
            finalizarAguardar();
        });
    }