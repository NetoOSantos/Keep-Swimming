
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

        fetch(`/medidas/ultimas/`, { cache: 'no-store' }).then(function (response) {
            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
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

    // function mediaMaquina(idMaquina) {

    //     fetch(`/medidas/buscarMediaMaquina/${idMaquina}`, { cache: 'no-store' }).then(function (response) {
    //         if (response.ok) {
    //             response.json().then(function (resposta) {
    //                 console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
    //                 resposta.reverse();

    // momento_grafico
    //                 for (let i = 0; i < resposta.length; i++) {
    //                     let publicacao = resposta[i];
    //                     span_mediaUmi.innerHTML = `${publicacao.mediaUmi}%`
    //                 }
    //             });
    //         } else {
    //             console.error('Nenhum dado encontrado ou erro na API');
    //         }
    //     })
    //         .catch(function (error) {
    //             console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    //         });

    // }


    // só altere aqui se souber o que está fazendo!
    // function plotarGrafico(resposta, idMaquina) {
    //     console.log('iniciando plotagem do gráfico...');


        

    //     var dados = {
    //         labels: [],
    //         datasets: [
    //             {
    //                 yAxisID: 'y-Maquina',
    //                 label: 'Maquina',
    //                 borderColor: '#32B9CD',
    //                 backgroundColor: '#32b9cd8f',
    //                 fill: true,
    //                 data: []
    //             }
    //         ]
    //     };

    //     for (i = 0; i < resposta.length; i++) {
    //         var registro = resposta[i];
    //         dados.labels.push(registro.momento_grafico);
    //         dados.datasets[0].data.push(registro.Maquina);
    //     }

    //     console.log(JSON.stringify(dados));

    //     var ctx = chartLine1.getContext('2d');
    //     window.grafico_linha = Chart.Line(ctx, {
    //         data: dados,
    //         //Configurações do gráfico
    //         options: {
    //             responsive: true,
    //             animation: { duration: 500 },
    //             hoverMode: 'index',
    //             stacked: false,
    //             title: {
    //                 display: true,
    //                 text: 'Histórico recente de Maquina'
    //             },
    //             scales: {
    //                 yAxes: [{
    //                     type: 'linear',
    //                     display: true,
    //                     position: 'left',
    //                     id: 'y-temperatura',
    //                 }, {
    //                     type: 'linear',
    //                     display: true,
    //                     position: 'right',
    //                     id: 'y-Maquina',

    //                     gridLines: {
    //                         drawOnChartArea: false,
    //                     },
    //                 }],
    //             }
    //         }
    //     });

    //     //Atualiza os dados de 2 em 2 segundos
    //     setTimeout(() => atualizarGrafico(idMaquina, dados), 2000);
    // }
    // graidient.addColorStop(0, 'rgba(167, 121, 232, 1)');
    // graidient.addColorStop(1, 'rgba(79, 92, 196, 1)'); 
    // só altere aqui se souber o que está fazendo!
    function plotarGrafico(resposta) {
        console.log('iniciando plotagem do gráfico...');


       

        var dados = {
            labels: [],
            datasets: [
                {
                    label:'usoCpu',
                    data: [9, 13, 11, 12, 15, 17, 21, 19],
                    backgroundColor: [
                        
                                                                                              ],
                    borderColor: [
                        
                                                                                              ],
                    borderWidth: 1
                },
                {
                    label: 'usoRam',
                    data: [9, 13, 11, 12, 15, 17, 21, 19],
                    backgroundColor: [
                        
                                                                                              ],
                    borderColor: [
                        
                                                                                              ],
                    borderWidth: 1
                }
            ]
        };

        for (i = 0; i < resposta.length; i++) {
            var registro = resposta[i];
            dados.labels.push(registro.momento_grafico);
            chartBar.datasets[1].data.push(registro.usoCPU);
        }

        console.log(JSON.stringify(dados));

       
        var ctx = chartBar.getContext('2d');
        window.grafico_barra = Chart.Line(ctx, {
            type: 'bar',
            data: dados,
               //Configurações do gráfico
            options: {
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
                        }
                    },
                }
            }
        });


        


        //Atualiza os dados de 2 em 2 segundos
        setTimeout(() => atualizarGrafico2(dados), 2000);
    }

    // só mexer se quiser alterar o tempo de atualização
    // ou se souber o que está fazendo!
    function atualizarGrafico(dados) {
        fetch(`/medidas/tempo-real/`, { cache: 'no-store' }).then(function (response) {
            if (response.ok) {
                response.json().then(function (novoRegistro) {

                    console.log(`Dados recebidos: ${JSON.stringify(novoRegistro)}`);
                    console.log(`Dados atuais do gráfico: ${dados}`);

                    // tirando e colocando valores no gráfico
                    dados.labels.shift(); // apagar o primeiro
                    dados.labels.push(novoRegistro[0].momento_grafico); // incluir um novo momento
                    dados.datasets[0].data.shift();  // apagar o primeiro de Maquina
                    dados.datasets[0].data.push(novoRegistro[0].Maquina); // incluir uma nova medida de Maquina


                    // Alertas por Cores de Maquina

                    if (novoRegistro[0].Maquina >= 35) {
                        img_alertas_umi.src = "../assets/errado_gif.gif"
                        dados.datasets[0].borderColor = 'red';
                        dados.datasets[0].backgroundColor = '#ff04008c';
                    } else if (novoRegistro[0].Maquina <= 19) {
                        img_alertas_umi.src = "../assets/errado_gif.gif"
                        dados.datasets[0].borderColor = '#483D8B';
                        dados.datasets[0].backgroundColor = '#826fff9c';

                    } else if ((novoRegistro[0].Maquina >= 20 && novoRegistro[0].Maquina <= 23) || novoRegistro[0].Maquina >= 28 && novoRegistro[0].Maquina <= 31) {
                        img_alertas_umi.src = "../assets/atencao_gif.gif"
                        dados.datasets[0].borderColor = '#FFFF00';
                        dados.datasets[0].backgroundColor = '#ffe6006b';
                    } else if (novoRegistro[0].Maquina > 23 && novoRegistro[0].Maquina < 28) {
                        dados.datasets[0].borderColor = '#32B9CD';
                        dados.datasets[0].backgroundColor = '#32b9cd8f';
                        img_alertas_umi.src = "../assets/correto_gif.gif"
                    }


                    window.grafico_linha.update();

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
    // só mexer se quiser alterar o tempo de atualização
    // ou se souber o que está fazendo!
    // function atualizarGrafico2( dados) {
    //     fetch(`/medidas/tempo-real/${idMaquina}`, { cache: 'no-store' }).then(function (response) {
    //         if (response.ok) {
    //             response.json().then(function (novoRegistro) {

    //                 console.log(`Dados recebidos: ${JSON.stringify(novoRegistro)}`);
    //                 console.log(`Dados atuais do gráfico: ${dados}`);

    //                 // tirando e colocando valores no gráfico
    //                 dados.labels.shift(); // apagar o primeiro
    //                 dados.labels.push(novoRegistro[0].momento_grafico); // incluir um novo momento
    //                 dados.datasets[0].data.shift();  // apagar o primeiro de temperatura_lm35
    //                 dados.datasets[0].data.push(novoRegistro[0].temperatura_lm35); // incluir uma nova medida de temperatura_lm35



    //                 // Alertas por Cores de Temperatura

    //                 if (novoRegistro[0].temperatura_lm35 >= 33) {
    //                     img_alertas_temp.src = "../assets/errado_gif.gif"
    //                     dados.datasets[0].borderColor = 'red';
    //                     dados.datasets[0].backgroundColor = 'red';

    //                 } else if (novoRegistro[0].temperatura_lm35 <= 19) {
    //                     img_alertas_temp.src = "../assets/errado_gif.gif"
    //                     dados.datasets[0].borderColor = '#483D8B';
    //                     dados.datasets[0].backgroundColor = '#826fff9c';

    //                 } else if ((novoRegistro[0].temperatura_lm35 >= 20 && novoRegistro[0].temperatura_lm35 <= 23) || novoRegistro[0].temperatura_lm35 >= 28 && novoRegistro[0].temperatura_lm35 <= 31) {
    //                     img_alertas_temp.src = "../assets/atencao_gif.gif"
    //                     dados.datasets[0].borderColor = '#FFFF00';
    //                     dados.datasets[0].backgroundColor = '#ffe6006b';
    //                 } else if (novoRegistro[0].temperatura_lm35 > 23 && novoRegistro[0].temperatura_lm35 < 28) {
    //                     dados.datasets[0].borderColor = '#00b300';
    //                     dados.datasets[0].backgroundColor = '#00800090';
    //                     img_alertas_temp.src = "../assets/correto_gif.gif"
    //                 }



    //                 window.grafico_linha2.update();

    //                 proximaAtualizacao = setTimeout(() => atualizarGrafico2(idMaquina, dados), 5000);
    //             });
    //         } else {
    //             console.error('Nenhum dado encontrado ou erro na API');
    //             proximaAtualizacao = setTimeout(() => atualizarGrafico2(idMaquina, dados), 5000);
    //         }
    //     })
    //         .catch(function (error) {
    //             console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    //         });

    // }


    // <!-- Script antigo para pegar as cores -->

    /* <script>
            function Monitorar() {
                window.location = './graficos.html'
            }
    
            function gerar_grafico() {
                var http = new XMLHttpRequest();
                http.open('GET', 'http://localhost:3000/medidas/tempo_permanencia', false);//LOCAL DE ONDE VEM OS DADOS
                http.send(null);
    
                var obj = JSON.parse(http.responseText);
                if (obj.length == 0) {
                    console.log("Nenhum dado a ser exibido")
                }
                else {
                    var lista = obj.data;
    
                    var vagas = [];
                    var totalHoras = [];
                    for (i = 0; i < lista.length; i++) {
                        vagas.push(lista[i].fksensor);
                        totalHoras.push(lista[i].tempo_de_permanencia)
                    }
    
                    const ctx = document.getElementById('myChart').getContext('2d');
                    const myChart = new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: vagas,
                            datasets: [{
                                label: 'Tempo de uso diário',
                                data: totalHoras,
                                backgroundColor: [
                                    'rgba(95, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(255, 159, 64, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255, 99, 132, 1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)',
                                    'rgba(153, 102, 255, 1)',
                                    'rgba(255, 159, 64, 1)'
                                ],
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scales: {
                                y: {
                                    beginAtZero: true
                                }
                            }
                        }
                    });
                }
            }
    
    
    
            const ctx = document.getElementById('myChart2').getContext('2d');
            const graidient = ctx.createLinearGradient(0, 0, 0, 250);
    
            graidient.addColorStop(0, 'rgba(167, 121, 232, 1)');
            graidient.addColorStop(1, 'rgba(79, 92, 196, 1)');
    
            const myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    color: 'black',
                    labels: ['Domingo', 'Segunda', 'Terca', 'Quarta', 'Quinta', 'Sexta', 'Sabado'],
                    datasets: [{
                        label: 'Tempo de uso por dia',
                        data: [9, 13, 11, 12, 15, 17, 21, 19],
                        backgroundColor: [
                            
                                                       graidient,
                            graidient,
                            graidient,
                            graidient
                        ],
                        borderColor: [
                            graidient,
                            graidient,
                            graidient,
                            graidient,
                            graidient,
                            graidient
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
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
                            }
                        },
                    }
                }
            });
    
    
    
            /* var ctxLine = document.getElementById("chartLine").getContext("2d");
             var rotulosLine = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"];
             var dataLine = [7040.00, 8222.00, 1100.00, 6724.00, 7788.00, 8880.00, 10937.00, 12954.00, 9998.00, 9045.00, 11100.00, 18000.00];
             var configLine = {
                 type: 'line',
                 data: {
                     labels: rotulosLine,
                     datasets: [
                         {
                             label: 'Lucro Mensal',
                             data: dataLine,
                             backgroundColor: [
                                 '#FF000022',
                                 '#FFFF0022',
                                 '#FF00FF22',
                                 '#00FFFF22',
                                 '#99009922',
                                 '#99990022',
                                 '#F0F00022',
                                 '#65002222',
                             ],
                             borderColor: [
                                 '#FF0000',
                                 '#FFFF00',
                                 '#FF00FF',
                                 '#00FFFF',
                                 '#990099',
                                 '#999900',
                                 '#F0F000',
                                 '#650022',
                             ],
                             borderWidth: 1
                         }
                     ]
                 },
                 options: {
     
                     maintainAspectRatio: false,
                     scales: {
                         y: {
                             beginAtZero: true,
                         }
                     }
                 }
             }
     */
  
    //         const ctx3 = document.getElementById('chartLine').getContext('2d');
    //         const gradientBG = ctx3.createLinearGradient(0, 0, 0, 250);
    
    
    
    //         gradientBG.addColorStop(0, 'rgba(167, 121, 232, 1)');
    //         gradientBG.addColorStop(1, 'rgba(79, 92, 196, 1)');
    
    
    
    
    //         const myChart3 = new Chart(ctx3, {
    //             type: 'bar',
    //             data: {
    //                 labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    //                 datasets: [{
    //                     label: 'Receita mensal',
    //                     data: [7040.00, 8222.00, 1100.00, 6724.00, 7788.00, 8880.00, 10937.00, 12954.00, 9998.00, 9045.00, 11100.00, 18000.00],
    //                     backgroundColor: [
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG
    //                     ],
    //                     borderColor: [
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG,
    //                         gradientBG
    //                     ],
    //                     borderWidth: 1
    //                 }]
    //             },
    //             options: {
    //                 plugins: {  // 'legend' now within object 'plugins {}'
    //                     legend: {
    //                         labels: {
    //                             color: "white",  // not 'fontColor:' anymore
    //                             // fontSize: 18  // not 'fontSize:' anymore
    //                             font: {
    //                                 size: 14 // 'size' now within object 'font {}'
    //                             }
    //                         }
    //                     }
    //                 },
    //                 scales: {
    //                     y: {
    //                         ticks: {
    //                             color: 'white'
    //                         },
    //                         beginAtZero: true
    //                     },
    //                     x: {
    //                         ticks: {
    //                             color: 'white'
    
    //                         }
    //                     },
    
    
    //                 }
    //             }
    //         });
    
    //         const ctx4 = document.getElementById('myChartLine').getContext('2d');
    //         const graidientBack = ctx4.createLinearGradient(0, 0, 0, 250);
    
    //         graidientBack.addColorStop(0, 'rgba(167, 121, 232, 1)');
    //         graidientBack.addColorStop(1, 'rgba(79, 92, 196, 1)');
    
    //         const myChart4 = new Chart(ctx4, {
    //             type: 'line',
    //             data: {
    //                 color: 'black',
    //                 labels: ['Domingo', 'Segunda', 'Terca', 'Quarta', 'Quinta', 'Sexta', 'Sabado'],
    //                 datasets: [{
    //                     label: 'Dia de maior consumo',
    //                     data: [9, 13, 11, 12, 15, 17, 21, 19],
    //                     backgroundColor: [
    //                         graidient,
    //                         graidient,
    //                         graidient,
    //                         graidient,
    //                         graidient,
    //                         graidient
    //                     ],
    //                     borderColor: [
    //                         graidient,
    //                         graidient,
    //                         graidient,
    //                         graidient,
    //                         graidient,
    //                         graidient
    //                     ],
    //                     borderWidth: 1
    //                 }]
    //             },
    //             options: {
    //                 maintainAspectRatio: false,
    //                 plugins: {  // 'legend' now within object 'plugins {}'
    //                     legend: {
    //                         labels: {
    //                             color: "white",  // not 'fontColor:' anymore
    //                             // fontSize: 18  // not 'fontSize:' anymore
    //                             font: {
    //                                 size: 14 // 'size' now within object 'font {}'
    //                             }
    //                         }
    //                     }
    //                 },
    //                 scales: {
    //                     y: {
    //                         ticks: {
    //                             color: 'white'
    //                         },
    //                         beginAtZero: true
    //                     },
    //                     x: {
    //                         ticks: {
    //                             color: 'white'
    //                         }
    //                     },
    //                 }
    //             }
    //         });
    
    
    
    
    
    
    //         setInterval(function () {
    //             gerar_grafico()
    //         }, 1000);
    
    
    
    //     function Monitorar() {
    //         window.location = './graficos.html'
    //     }
    // </script>  */