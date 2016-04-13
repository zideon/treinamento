/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.domain.Turma;
import br.uff.sti.model.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @RequestMapping(value ="", method = RequestMethod.GET)
    ResponseEntity<Iterable<Turma>> todos(){
        return new ResponseEntity<>(turmaService.todos(),HttpStatus.OK);
    }
    
    @RequestMapping(value = "{codigo}", method = RequestMethod.GET)
    ResponseEntity<Turma> buscar(@PathVariable String codigo) {
        Turma turma= turmaService.busca(codigo);
        if(turma==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(turma,HttpStatus.OK);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.GET)
    ResponseEntity<Turma> criarGet( @RequestParam(value = "codigo",required = true) String codigo, @RequestParam(value = "professor",required = true) String professor) {
        Turma turma = turmaService.salva(turmaService.cria(codigo, professor));
        if(turma==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(turma,HttpStatus.OK);
    }
    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    ResponseEntity<Turma> criarPost( @RequestParam(value = "codigo",required = true) String codigo, @RequestParam(value = "professor",required = true) String professor) {
        Turma turma = turmaService.salva(turmaService.cria(codigo, professor));
        if(turma==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(turma,HttpStatus.OK);
    }
}
