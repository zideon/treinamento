/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.domain.Log;
import br.uff.sti.model.domain.Turma;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
@Service
public class TurmaServiceBean implements TurmaService{
    @Autowired
    private TurmaDAO turmaDAO;

    @Autowired
    private LogService logService;

    
    @Override
    public Turma salva(Turma turma) {
       turma = salvaT(turma);
       if(turma==null){
           logService.salva(logService.cria("salvaTurma", Log.FALHA));
       }
       return turma;
    }
     @Transactional
    public Turma salvaT(Turma turma) {
        try {
            turmaDAO.save(turma);
            logService.salva(logService.cria("salvaTurma", Log.SUCESSO));
            return turma;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    @Transactional
    @Override
    public Turma busca(String codigo) {
        try {
            Turma turma = turmaDAO.findOne(codigo);
            logService.salva(logService.cria("salvaTurma", Log.SUCESSO));
            return turma;
        } catch (Exception ex) {
            logService.salva(logService.cria("buscaTurma", Log.FALHA));
        }
        return null;
    }
     @Transactional
    @Override
    public Iterable<Turma> todos() {
        return turmaDAO.findAll();
    }

    @Override
    public Turma cria(Object... objs) {
        Turma turma = new Turma()
                .addCodigo((String)objs[0])
                .addProfessor((String)objs[1]);
        return turma;
    }

    @Override
    public List<Turma> buscaPorAtributos(Turma modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
