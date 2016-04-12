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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author uff
 */
@RestController
@RequestMapping(value = "/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<AlunoTurma> todos(){
        return inscricaoService.todos();
    }

    @RequestMapping(value = "busca/", method = RequestMethod.GET)
    List<AlunoTurma> buscar(@RequestParam(value = "matAluno",required = false) String matriculaAluno,
            @RequestParam(value = "codTurma",required = false) String codigoTurma) {
        if(codigoTurma!= null && matriculaAluno==null){
            return inscricaoService.buscarPorTurma(codigoTurma);
        }else if(codigoTurma== null && matriculaAluno!=null){
            return inscricaoService.buscarPorAluno(matriculaAluno);
        }else if(codigoTurma!= null && matriculaAluno!=null){
            return inscricaoService.buscarPorAlunoETurma(matriculaAluno, codigoTurma);
        }
        return null;
    }

    @RequestMapping(value = "novo/", method = RequestMethod.GET)
    AlunoTurma criar(@RequestParam(value = "matAluno",required = true) String matriculaAluno
            , @RequestParam(value = "codTurma",required = true) String codigoTurma) {
       return inscricaoService.salva(matriculaAluno, codigoTurma);
    }
    
    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    AlunoTurma criarPost(@RequestParam(value = "matAluno",required = true) String matriculaAluno
            , @RequestParam(value = "codTurma",required = true) String codigoTurma) {
       return inscricaoService.salva(matriculaAluno, codigoTurma);
    }
}
