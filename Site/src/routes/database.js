var mysql = require('mysql2');
var connection = mysql.createConnection({
    host     : 'localhost', /* NORMALMENTE localhost */
    user     : 'root', /* NORMALMENTE root */
    password : 'keepSwimming', /* SENHA DO BANCO DE DADOS */
    database : 'Thetrooper14#7' /* NOME DO BANCO DE DADOS QUE ESTA SENDO USADO */
});

connection.connect(function(err) {
    if (err) throw err;
    console.log('Conectado com sucesso!')
});

module.exports = {connection, save};
