/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.domain.Turma;
import br.uff.sti.model.dao.AlunoDAO;
import br.uff.sti.model.dao.AlunoTurmaDAO;
import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.dao.TurmaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uff
 */
@Service
public class TurmaService {
    
    @Autowired
    TurmaDAO turmaDAO;
    
    @Autowired
    AlunoDAO alunoDAO;
    
    @Autowired
    CursoDAO cursoDAO;
    
    @Autowired
    AlunoTurmaDAO alunoTurmaDAO;
    
    @PostConstruct
    public void init(){
      
        for (int i = 0; i < 10; i++) { 
            cursoDAO.save(new Curso(""+i,"comp"+i));
        }
        for (int i = 0; i < 10; i++) {
            turmaDAO.save(new Turma(""+i,"fulano"+i)); 
        }
        for (int i = 0; i < 10; i++) {
            alunoDAO.save(new Aluno(""+i,"fabio"+i,cursoDAO.findOne(""+i))); 
        }
        for (int i = 0; i < 10; i++) {
            alunoTurmaDAO.save(new AlunoTurma(alunoDAO.findOne(""+i),
                    turmaDAO.findOne(""+i)));
        }
        

    }
}
