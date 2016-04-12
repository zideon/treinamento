/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private LogService logService;

    @Transactional
    public Curso salva(Curso curso) {
        try {
            cursoDAO.save(curso);
            logService.salva("salvaCurso", Log.SUCESSO);
            return curso;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public Curso salva(String codigo, String nome) {
        Curso curso = new Curso(codigo, nome);
        curso = salva(curso);
        if (curso == null) {
            logService.salva("salvaCurso", Log.FALHA);
        }
        return curso;
    }

    @Transactional
    public Curso busca(String codigo) {
        try {
            Curso curso = cursoDAO.findOne(codigo);
            if (curso == null) {
                throw new Exception("");
            }
            logService.salva("buscaCurso", Log.SUCESSO);
            return curso;
        } catch (Exception ex) {
            logService.salva("buscaCurso", Log.FALHA);
        }
        return null;
    }
}
