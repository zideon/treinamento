/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fabio
 */
@Controller
@ComponentScan
public class IndexController {
   @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "hello");
        model.addAttribute("view", "fragments/textcontent");
        return "index";
    }
    
}
