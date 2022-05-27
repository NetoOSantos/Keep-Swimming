package com.mycompany.swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class keepSwimmingSemInter {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu login ");

        System.out.println("Digite seu nome de usuario:");

        String EMAIL = leitor.nextLine();

        System.out.println("Digite seu senha de usuario:");

        String SENHA = leitor.nextLine();

        //Instancia a classe Connection
        //Instancia um objeto Jdbc e pega o retorno getDataSource
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List funcionario = new ArrayList();
        Funcionario usuario = new Funcionario();
        BeanPropertyRowMapper Bean = new BeanPropertyRowMapper();

        List<Funcionario> Select = con.query("SELECT * FROM FUNCIONARIO",
                new BeanPropertyRowMapper(Funcionario.class));

        for (Funcionario func : Select) {
            if (func.getEMAIL().equals(EMAIL) && func.getSENHA().equals(SENHA)) {
                System.out.println("LOGADO COM SUCESSO!");
                
                
                TelaPrincipalsemI tela = new TelaPrincipalsemI();
                tela.inicializacao();

            } else {

                System.out.println("Ouve um erro! Tente novamente!");
            }
        }
    }
}
