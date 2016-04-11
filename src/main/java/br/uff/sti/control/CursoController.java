/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author uff
 */
@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    private CursoDAO cursoDAO;

    @RequestMapping(value = "buscar/cod/{codigo}", method = RequestMethod.GET)
    Curso buscar(@PathVariable String codigo) {
        return cursoDAO.findOne(codigo);
    }

    @RequestMapping(value = "criar/cod/{codigo}/nome/{nome}", method = RequestMethod.GET)
    Curso criar(@PathVariable String codigo, @PathVariable String nome) {
        Curso curso = new Curso(codigo, nome);
        cursoDAO.save(curso);
        return curso;
    }
}
