/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.domain.Turma;
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
public class AlunoController {

    
    @Autowired
    private TurmaService turmaService;
    
    @Autowired
    private AlunoDAO alunoDAO;
    @Autowired
    private CursoDAO cursoDAO;
    
    @Autowired
    private TurmaDAO turmaDAO;
    
    @Autowired
    private AlunoTurmaDAO alunoTurmaDAO;
     
   

    @RequestMapping(value = "/", method = RequestMethod.GET)
    AlunoTurma homeRP() {     
        return alunoTurmaDAO.findByTurma(turmaDAO.findOne("1"));
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
    Aluno criarAlunoRP(@RequestParam(value = "matricula", required = false) String mat) {
        Aluno aluno = new Aluno(mat, "fabio", new Curso("computacao", "123"));
        return aluno;
    }

    @RequestMapping(value = "aluno/{matricula}", method = RequestMethod.GET)
    Aluno criarAlunoPV(@PathVariable String matricula) {
        Aluno aluno = new Aluno(matricula, "fabio", new Curso("computacao", "123"));
        return aluno;
    }

    @RequestMapping(value = "/{op1}/{op2}", method = RequestMethod.GET)
    String homePV(@PathVariable int op1, @PathVariable int op2) {
        return op1 + "+" + op2 + "=" + (op1 + op2);
    }

}
