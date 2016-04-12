/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.LogDAO;
import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.domain.Log;
import br.uff.sti.model.domain.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
@Service
public class TurmaService {

    @Autowired
    private TurmaDAO turmaDAO;

    @Autowired
    private LogService logService;

    @Transactional
    public Turma salva(Turma turma) {
        try {
            turmaDAO.save(turma);
            logService.salva("salvaTurma", Log.SUCESSO);
            return turma;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Transactional
    public Turma salva(String codigo, String professor) {
        Turma turma = new Turma(codigo, professor);
        turma =  salva(turma);
        if(turma ==null){
             logService.salva("salvaTurma", Log.FALHA);
        }
        return turma;
    }

    @Transactional
    public Turma busca(String codigo) {
        try {
            Turma turma = turmaDAO.findOne(codigo);
            logService.salva("salvaTurma", Log.SUCESSO);
            return turma;
        } catch (Exception ex) {
            logService.salva("buscaTurma", Log.FALHA);
        }
        return null;
    }
}
