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
import br.uff.sti.model.service.BancoDeDadosService;
import br.uff.sti.model.service.InscricaoService;
import java.util.List;
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
    private InscricaoService inscricaoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String descricao() {
        return "modelo de uma uma inscrição com aluno e turma ";
    }

    @RequestMapping(value = "buscar/codTurma/{codigoTurma}", method = RequestMethod.GET)
    List<AlunoTurma> buscarPorTurma(@PathVariable String codigoTurma) {
        return inscricaoService.buscarPorTurma(codigoTurma);
    }

    @RequestMapping(value = "buscar/matAluno/{matriculaAluno}", method = RequestMethod.GET)
    List<AlunoTurma> buscarPorAluno(@PathVariable String matriculaAluno) {
        return inscricaoService.buscarPorAluno(matriculaAluno);

    }

    @RequestMapping(value = "criar/matAluno/{matriculaAluno}/codTurma/{codigoTurma}", method = RequestMethod.GET)
    AlunoTurma criar(@PathVariable String matriculaAluno, @PathVariable String codigoTurma) {
       return inscricaoService.salva(matriculaAluno, codigoTurma);
    }
}
