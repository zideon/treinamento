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
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    
  
    
    //hsqldb e spring boot
    //1) usar @PathVariable -- aluno/23456
    //2) transformar curso em uma entidade
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        
    }
   
}

