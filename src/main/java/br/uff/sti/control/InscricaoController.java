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
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Turma;
import br.uff.sti.model.service.BancoDeDadosService;
import br.uff.sti.model.service.InscricaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.CREATED;
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
@RequestMapping(value = "/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<Iterable<AlunoTurma>> todos(){
        return new ResponseEntity<>( inscricaoService.todos(),HttpStatus.OK);
    }
    //criar modelo vazio de aluno turma para a busca
    @RequestMapping(value = "busca/", method = RequestMethod.GET)
    ResponseEntity<List<AlunoTurma>> buscar(
            @RequestParam(value = "matAluno",required = false) String matriculaAluno,
            @RequestParam(value = "codTurma",required = false) String codigoTurma
    ) {
        AlunoTurma alunoTurma = new AlunoTurma()
                .addAluno( new Aluno().addMatricula(matriculaAluno))
                .addTurma(new Turma().addCodigo(codigoTurma));
   
        List<AlunoTurma> list = inscricaoService.buscaPorAtributos(alunoTurma);
        if(list==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value = "novo/", method = RequestMethod.GET)
    ResponseEntity<AlunoTurma> criar(
            @RequestParam(value = "matAluno",required = true) String matriculaAluno,
            @RequestParam(value = "codTurma",required = true) String codigoTurma
    ) {
       AlunoTurma alunoTurma = inscricaoService.salva(inscricaoService.cria(matriculaAluno,codigoTurma));
        if(alunoTurma==null){
           return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(alunoTurma,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    ResponseEntity<AlunoTurma> criarPost(@RequestParam(value = "matAluno",required = true) String matriculaAluno
            , @RequestParam(value = "codTurma",required = true) String codigoTurma) {
        AlunoTurma alunoTurma = inscricaoService.salva(inscricaoService.cria(matriculaAluno,codigoTurma));
        if(alunoTurma==null){
           return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(alunoTurma,HttpStatus.CREATED);
    }
}
