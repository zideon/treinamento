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
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<Iterable<Curso>> todos() {
        return new ResponseEntity<>(cursoService.todos(), HttpStatus.OK);
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.GET)
    ResponseEntity<Curso> buscar(
            @PathVariable String codigo
    ) {
        Curso curso = cursoService.busca(codigo);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.GET)
    ResponseEntity<Curso> criarGet(
            @RequestParam(value = "codigo", required = true) String codigo,
            @RequestParam(value = "nome", required = true) String nome
    ) {
        Curso curso = cursoService.salva(cursoService.cria(codigo, nome));
        if(curso ==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    ResponseEntity<Curso> criarPost(
            @RequestParam(value = "codigo", required = true) String codigo, 
            @RequestParam(value = "nome", required = true) String nome
    ) {
        Curso curso = cursoService.salva(cursoService.cria(codigo, nome));
        if(curso ==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }
}
