/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author uff
 */
@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping(value ="", method = RequestMethod.GET)
    Iterable<Curso> todos(){
        return cursoService.todos();
    }
    
    @RequestMapping(value = "{codigo}", method = RequestMethod.GET)
    Curso buscar(@PathVariable String codigo) {
        return cursoService.busca(codigo);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.GET)
    Curso criarGet(@RequestParam(value = "codigo",required = true) String codigo
            , @RequestParam(value = "nome",required = true) String nome) {
       return cursoService.salva(codigo, nome);
    }
    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    Curso criarPost(@RequestParam(value = "codigo",required = true) String codigo
            , @RequestParam(value = "nome",required = true) String nome) {
       return cursoService.salva(codigo, nome);
    }
}
