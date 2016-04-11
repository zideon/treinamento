/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.AlunoDAO;
import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
@Service
public class AlunoService {
    
    @Autowired
    private AlunoDAO alunoDAO;
    
    @Autowired
    private CursoDAO cursoDAO;
    
    @Transactional
    public Aluno salva(Aluno aluno) {
        alunoDAO.save(aluno);
        return aluno;
    }
    @Transactional
    public Aluno salva(String matricula, String nome, String codCurso) {
        Aluno aluno = new Aluno(matricula, nome, cursoDAO.findOne(codCurso));
        alunoDAO.save(aluno);
        return aluno;
    }
}
