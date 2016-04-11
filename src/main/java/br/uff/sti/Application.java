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
    
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);  
    }
   
}

