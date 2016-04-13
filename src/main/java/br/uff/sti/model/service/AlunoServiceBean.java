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
public class AlunoServiceBean implements AlunoService {

    @Autowired
    private AlunoDAO alunoDAO;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private LogService logService;

    @Override
    public Aluno salva(Aluno aluno) {
        aluno = salvaT(aluno);
        if (aluno == null) {
            logService.salva(logService.cria("salvaAluno", Log.FALHA));
        }
        return aluno;
    }

    @Transactional
    public Aluno salvaT(Aluno aluno) {

        try {
            alunoDAO.save(aluno);
            logService.salva(logService.cria("salvaAluno", Log.SUCESSO));
            return aluno;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

   

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Aluno busca(String matricula) {
        try {
            Aluno aluno = alunoDAO.findOne(matricula);
            if (aluno == null) {
                throw new Exception("");
            }
            logService.salva(logService.cria("buscaAluno", Log.SUCESSO));
            return aluno;
        } catch (Exception ex) {
            logService.salva(logService.cria("buscaAluno", Log.FALHA));
        }
        return null;
    }

    public Iterable<Aluno> todos() {

        return alunoDAO.findAll();
    }

    @Override
    public Aluno cria(Object... objs) {
        Aluno novo = new Aluno().addMatricula((String) objs[0])
                .addNome((String) objs[1])
                .addCurso(cursoService.busca((String) objs[2]));
        return novo;
    }

    @Override
    public List<Aluno> buscaPorAtributos(Aluno modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
