/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti;

/**
 *
 * @author uff
 */
import br.uff.sti.model.service.BancoDeDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
public class Application {
   @Autowired
   private BancoDeDadosService turmaService; 
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);  
    }

}

