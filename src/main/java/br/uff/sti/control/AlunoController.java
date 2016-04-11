/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.dao.AlunoDAO;
import br.uff.sti.model.dao.AlunoTurmaDAO;
import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.service.TurmaService;
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
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoDAO alunoDAO;
    @Autowired
    private CursoDAO cursoDAO;
    
    @RequestMapping(value = "buscar/mat/{matricula}", method = RequestMethod.GET)
    Aluno buscar(@PathVariable String matricula) {
        Aluno aluno = new Aluno(matricula, "fabio", new Curso("computacao", "123"));
         return alunoDAO.findOne(matricula);
    }
    @RequestMapping(value = "criar/mat/{matricula}/nome/{nome}/curso/{codCurso}", method = RequestMethod.GET)
    Aluno criar(@PathVariable String matricula,@PathVariable String nome,@PathVariable String codCurso) {
        Aluno aluno = new Aluno(matricula, "fabio", cursoDAO.findOne(codCurso));
        alunoDAO.save(aluno);
        return aluno;
    }
 
}
