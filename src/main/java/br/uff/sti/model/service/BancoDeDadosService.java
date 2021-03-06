/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.domain.Turma;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uff
 */
@Service
public class BancoDeDadosService {
    
    @Autowired
    TurmaService turmaService;
    
    @Autowired
    AlunoService alunoService;
    
    @Autowired
    CursoService cursoService;
    
    @Autowired
    InscricaoService inscricaoService;
    
    @PostConstruct
    public void init(){
      
        for (int i = 0; i < 10; i++) { 
            cursoService.salva(cursoService.cria(""+i,"comp"+i));
        }
        for (int i = 0; i < 10; i++) {
            turmaService.salva(turmaService.cria(""+i,"fulano"+i)); 
        }
        for (int i = 0; i < 10; i++) {
            alunoService.salva(alunoService.cria(""+i,"fabio"+i,""+i)); 
        }
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
            inscricaoService.salva(inscricaoService.cria(""+j,""+i));
        }
        }
        
        

    }
}
