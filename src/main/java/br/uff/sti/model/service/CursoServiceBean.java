/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.CursoDAO;
import br.uff.sti.model.domain.Curso;
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
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CursoServiceBean implements CursoService{
    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private LogService logService;

  
    @Override
    public Curso salva(Curso curso) {
        curso = salvaT(curso);
         if (curso == null) {
            logService.salva(logService.cria("salvaCurso", Log.FALHA));
        }
        return curso;
    }
     @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Curso salvaT(Curso curso) {
        try {
            cursoDAO.save(curso);
            logService.salva(logService.cria("salvaCurso", Log.SUCESSO));
            return curso;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Curso busca(String codigo) {
        try {
            Curso curso = cursoDAO.findOne(codigo);
            if (curso == null) {
                throw new Exception("");
            }
            logService.salva(logService.cria("buscaCurso", Log.SUCESSO));
            return curso;
        } catch (Exception ex) {
            logService.salva(logService.cria("buscaCurso", Log.FALHA));
        }
        return null;
    }
    @Override
    public Iterable<Curso> todos(){
        return cursoDAO.findAll();
    }

    @Override
    public Curso cria(Object... objs) {
        Curso curso = new Curso()
                .addCodigo((String)objs[0])
                .addNome((String)objs[1]);
        return curso;
    }

    @Override
    public List<Curso> buscaPorAtributos(Curso modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
