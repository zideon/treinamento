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
@RequestMapping(value = "/aluno")
public class TurmaController {

    @Autowired
    private TurmaDAO turmaDAO;

    @RequestMapping(value = "buscar/cod/{codigo}", method = RequestMethod.GET)
    Turma buscar(@PathVariable String codigo) {
        return turmaDAO.findOne(codigo);
    }

    @RequestMapping(value = "criar/cod/{codigo}/professor/{professor}", method = RequestMethod.GET)
    Turma criar(@PathVariable String codigo,@PathVariable String professor) {
        Turma turma = new Turma(codigo, professor);
        turmaDAO.save(turma);
        return turma;
    }
}
