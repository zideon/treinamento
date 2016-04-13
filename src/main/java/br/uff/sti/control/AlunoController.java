/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author uff
 */
@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<Iterable<Aluno>> todos() {
        return new ResponseEntity<>(alunoService.todos(), HttpStatus.OK);
    }

    @RequestMapping(value = "{matricula}", method = RequestMethod.GET)
    ResponseEntity<Aluno> buscar(
            @PathVariable String matricula
    ) {
        Aluno aluno = alunoService.busca(matricula);
        if (aluno == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.GET)
    ResponseEntity<Aluno> criarGet(
            @RequestParam(value = "matricula", required = true) String matricula,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "curso", required = true) String codCurso
    ) {
        Aluno aluno = alunoService.salva(alunoService.cria(matricula, nome, codCurso));
        if(aluno==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    ResponseEntity<Aluno> criarPost(
            @RequestParam(value = "matricula", required = true) String matricula,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "curso", required = true) String codCurso
    ) {
        Aluno aluno = alunoService.salva(alunoService.cria(matricula, nome, codCurso));
        if(aluno==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Aluno> criarPorObjeto(
            @RequestBody Aluno aluno
    ) {
        aluno = alunoService.salva(aluno);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }
    //Requestbody!=model atribute
    //exception handler spring
}
