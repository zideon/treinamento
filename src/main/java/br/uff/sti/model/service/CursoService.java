/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Curso;
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
    
    @Transactional
    public Curso salva(Curso curso) {
        cursoDAO.save(curso);
        return curso;
    }
    @Transactional
    public Curso salva(String codigo, String nome) {
        Curso curso = new Curso(codigo, nome);
        cursoDAO.save(curso);
        return curso;
    }
}
