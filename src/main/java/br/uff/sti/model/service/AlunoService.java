/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.AlunoDAO;
import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Log;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    private CursoService cursoService;

    @Autowired
    private LogService logService;

    @Transactional
    public Aluno salva(Aluno aluno) {
        try {
            alunoDAO.save(aluno);
            logService.salva("salvaAluno", Log.SUCESSO);
            return aluno;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

   
    public Aluno salva(String matricula, String nome, String codCurso) {
        
            Aluno aluno = new Aluno(matricula, nome, cursoService.busca(codCurso));
            aluno= salva(aluno);
            if(aluno==null){
                logService.salva("salvaAluno", Log.FALHA);
            }
            return aluno;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Aluno busca(String matricula) {
        try {
            Aluno aluno = alunoDAO.findOne(matricula);
            if(aluno==null){
                throw new Exception("");
            }
            logService.salva("buscaAluno",Log.SUCESSO);
            return aluno;
        } catch (Exception ex) {
            logService.salva("buscaAluno",  Log.FALHA);
        }
        return null;
    }
    public Iterable<Aluno> todos(){
        
        return alunoDAO.findAll();
    }
}
