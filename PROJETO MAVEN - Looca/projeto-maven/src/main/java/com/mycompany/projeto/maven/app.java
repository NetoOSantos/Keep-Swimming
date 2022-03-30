
package com.mycompany.projeto.maven;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.javafaker.Faker;
import java.util.List;

public class app {
    
    public static void main(String[] args) {
        
        Faker faker = new Faker();
        
        System.out.println(faker.name().fullName());
        
        System.out.println("=".repeat(30));

// ------------------------------------------------
        
        Looca looca = new Looca();
        
        Sistema sistema = looca.getSistema();
        
//          System.out.println(looca.getSistema());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getGrupoDeProcessos());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getGrupoDeServicos());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getMemoria());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getProcessador());
//         System.out.println("=".repeat(30));
//        System.out.println(looca.getTemperatura());
        
        System.out.println("=".repeat(30));
        
// --------------------------------------------------      
        
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        
        List<Disco> discos = grupoDeDiscos.getDiscos();
        
        for (Disco disco : discos) {
            System.out.println(disco);
        }
    }
    
}
