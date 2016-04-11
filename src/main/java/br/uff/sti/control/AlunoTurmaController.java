/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.dao.AlunoDAO;
import br.uff.sti.model.dao.AlunoTurmaDAO;
import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Turma;
import br.uff.sti.model.service.TurmaService;
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
@RequestMapping(value = "/inscricao")
public class AlunoTurmaController {
     @Autowired
    private TurmaService turmaService;
    
    @Autowired
    private AlunoTurmaDAO alunoTurmaDAO;
    
    @Autowired
    private AlunoDAO alunoDAO;
    
    @Autowired
    private TurmaDAO turmaDAO;
    
    @RequestMapping(value = "buscar/codTurma/{codigoTurma}", method = RequestMethod.GET)
    AlunoTurma buscarPorTurma(@PathVariable String codigoTurma) {
        return alunoTurmaDAO.findByCodigoDaTurma(codigoTurma);
    }
    @RequestMapping(value = "buscar/matAluno/{matriculaAluno}", method = RequestMethod.GET)
    AlunoTurma buscarPorAluno(@PathVariable String matriculaAluno) {
        return alunoTurmaDAO.findByMatriculaDoAluno(matriculaAluno);
    }

    @RequestMapping(value = "criar/matAluno/{matriculaAluno}/codTurma/{codigoTurma}", method = RequestMethod.GET)
    AlunoTurma criar(@PathVariable String matriculaAluno,@PathVariable String codigoTurma) {
        AlunoTurma alunoTurma = new AlunoTurma(alunoDAO.findOne(matriculaAluno), turmaDAO.findOne(codigoTurma));
        alunoTurmaDAO.save(alunoTurma);
        return alunoTurma;
    }
}
