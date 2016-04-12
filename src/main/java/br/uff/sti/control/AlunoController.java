/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.service.AlunoService;
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
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    
    @RequestMapping(value ="/", method = RequestMethod.GET)
    String descricao(){
        return "modelo de um aluno com matricula ,nome e curso";
    }
    @RequestMapping(value = "buscar/mat/{matricula}", method = RequestMethod.GET)
    Aluno buscar(@PathVariable String matricula) {
        return alunoService.busca(matricula);
    }
    @RequestMapping(value = "criar/mat/{matricula}/nome/{nome}/curso/{codCurso}", method = RequestMethod.GET)
    Aluno criar(@PathVariable String matricula,@PathVariable String nome,@PathVariable String codCurso) {
        return alunoService.salva(matricula, nome, codCurso);
    }
 
}
