
package com.mycompany.projetoindividual;

import java.util.Scanner;
import jdk.jshell.execution.Util;

public class ProjedoIndividual {
    
    public static void main(String[] args) {
         
        Scanner leitor = new Scanner(System.in);
        
        UtilProjetoIndividual util = new UtilProjetoIndividual();
        
        System.out.println("Selecione uma das 5 Opções: ");
        Integer caso = leitor.nextInt();
        
        switch (caso) {
            case 1:
                System.out.println("insira unm numero para tabuada: ");
                Integer numero = leitor.nextInt();
                
                util.tabuada(numero);
                
                break;
            case 2:
                
                System.out.println("Insira sua renda: ");
                Double renda = leitor.nextDouble();
        
                util.quantidadeSalarios(renda);
                
                break;
            case 3:
                 
                System.out.println("Insira um numero de 0 a 10: ");
                    Integer numeroSorteio = leitor.nextInt();
                
                    util.Sorteio(numeroSorteio);
                
                break;
            case 4:
                 
                if (caso.equals(4)) {
                    System.out.println("Programa Encerrado!");
                }
                
                break;
            case 5: 
                 
                System.out.println("Insita numeros para serem somados"
                     + " e 0 para apresentar o resultado: ");
                Integer numerosoma = leitor.nextInt();
                
                        util.soma(numerosoma);
                 
                break;
            default:
                System.out.println("Opção invalida! Escolha uma opção de 1 a 4");
                break;
        }
    
    }
    
}
