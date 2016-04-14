/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.service.AlunoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author uff
 */
//@RestController
@Controller
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String todos(Model model) {
       model.addAttribute("alunos", alunoService.todos());
       model.addAttribute("view", "fragments/exibeAlunosContent");
       return "index";
    }
    
    @RequestMapping(value = "/{matricula}", method = RequestMethod.GET)
    String buscar(@PathVariable String matricula,Model model) {
        Aluno aluno = alunoService.busca(matricula);
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        model.addAttribute("alunos", alunos);
        model.addAttribute("view", "fragments/exibeAlunosContent");
        return "index";
    }
    @RequestMapping(value = "busca/", method = RequestMethod.POST)
    String buscarPost(@RequestParam(value = "matricula", required = true) String matricula,Model model) {
        Aluno aluno = alunoService.busca(matricula);
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        model.addAttribute("alunos", alunos);
        model.addAttribute("view", "fragments/exibeAlunosContent");
        return "index";
    }
//
    @RequestMapping(value = "cadastra/", method = RequestMethod.GET)
    String criarPost( Model model) {
        
        model.addAttribute("view", "fragments/criaAlunoContent");
        return "index";
    }
    
    @RequestMapping(value = "novo/", method = RequestMethod.POST)
    String criarPost(
            @RequestParam(value = "matricula", required = true) String matricula,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "curso", required = true) String codCurso,
            Model model
    ) {
        Aluno aluno = alunoService.salva(alunoService.cria(matricula, nome, codCurso));
         List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        model.addAttribute("alunos", alunos);
        model.addAttribute("view", "fragments/exibeAlunosContent");
        return "index";
    }
    
    
    
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    ResponseEntity<Iterable<Aluno>> todos() {
//        return new ResponseEntity<>(alunoService.todos(), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "{matricula}", method = RequestMethod.GET)
//    ResponseEntity<Aluno> buscar(
//            @PathVariable String matricula
//    ) {
//        Aluno aluno = alunoService.busca(matricula);
//        if (aluno == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(aluno, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "novo/", method = RequestMethod.POST)
//    ResponseEntity<Aluno> criarPost(
//            @RequestParam(value = "matricula", required = true) String matricula,
//            @RequestParam(value = "nome", required = true) String nome,
//            @RequestParam(value = "curso", required = true) String codCurso
//    ) {
//        Aluno aluno = alunoService.salva(alunoService.cria(matricula, nome, codCurso));
//        if(aluno==null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
//    }

    //Requestbody!=model atribute
    //exception handler spring
}
