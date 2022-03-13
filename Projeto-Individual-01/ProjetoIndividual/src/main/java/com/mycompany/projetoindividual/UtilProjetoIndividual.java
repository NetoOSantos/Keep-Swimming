
package com.mycompany.projetoindividual;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class UtilProjetoIndividual {
    
    Scanner leitor = new Scanner(System.in);
    
    void tabuada (Integer numero) {
    
         if (numero < 10) {
            Integer um = numero * 1;
            Integer dois = numero * 2;
            Integer tres = numero * 3;
            Integer quatro = numero * 4;
            Integer cinco = numero * 5;
            Integer seis = numero * 6;
            Integer sete = numero * 7;
            Integer oito = numero * 8;
            Integer nove = numero * 9;
            Integer dez = numero * 10;
            
            System.out.println(String.format("Tabuada do %d \n", numero));
            System.out.println(String.format("%d X 1 = %d \n", numero, um));
            System.out.println(String.format("%d X 2 = %d \n", numero, dois));
            System.out.println(String.format("%d X 3 = %d \n", numero, tres));
            System.out.println(String.format("%d X 4 = %d \n", numero, quatro));
            System.out.println(String.format("%d X 5 = %d \n", numero, cinco));
            System.out.println(String.format("%d X 6 = %d \n", numero, seis));
            System.out.println(String.format("%d X 7 = %d \n", numero, sete));
            System.out.println(String.format("%d X 8 = %d \n", numero, oito));
            System.out.println(String.format("%d X 9 = %d \n", numero, nove));
            System.out.println(String.format("%d X 10 = %d \n", numero, dez));
        }
        
    }
    
    void quantidadeSalarios (Double renda) {
        
        Double salariosMinimos = renda / 1100;
        
        String frase = "Você recebe aproximadamente %.1f salários minimos.\n"
                + "você pertence a classe social: %s";
        
        String classe = "";
        
        if (renda >= 10000 && renda < 20000){
            classe = "B";
            
            System.out.println(String.format(frase, salariosMinimos, classe));    
        }else if (renda >= 4000 && renda < 10000){
            classe = "C";
            
            System.out.println(String.format(frase, salariosMinimos, classe));    
        }else if (renda >= 2000 && renda < 4000){
            classe = "D";
            
            System.out.println(String.format(frase, salariosMinimos, classe));    
        }else if (renda < 2000){
            classe = "E";
            
            System.out.println(String.format(frase, salariosMinimos, classe));    
        } else {
            classe = "A";
            
            System.out.println(String.format(frase, salariosMinimos, classe));
        }

    } 
    
    void soma (Integer numerosoma) {
    
        Integer soma = 0;
        
        while (true) {            
            if (numerosoma != 0) {
                
                soma += numerosoma++;
                numerosoma = leitor.nextInt();
            }else {
                System.out.println(soma);
                break;
            }
              
    }
  }
    
    void Sorteio (Integer numeroSorteio){
    
           for (int contador = 1; contador > 0; contador++) {
            Integer random = ThreadLocalRandom.current().nextInt(0,11);
            
            if (numeroSorteio != random) {
                System.out.println(String.format("O numero sorteado foi: %d",random));
            }else if (contador >= 3) {
                System.out.println("Você é MUITO sortudo");
            }else if (contador >= 4 && contador <= 10) {
                System.out.println("Você é sortudo");
            }else if (contador >= 10) {
                System.out.println("É melhor você parar de apostar e ir trabalhar");
            }
            break;
        }
        
    }
}
