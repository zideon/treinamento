/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.LogDAO;
import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.domain.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
public class TurmaService {

    @Autowired
    private TurmaDAO turmaDAO;
    
    @Autowired
    private LogService logService;

    @Transactional
    public Turma salva(Turma turma) {
        turmaDAO.save(turma);
        return turma;
    }

    @Transactional
    public Turma salva(String codigo, String professor) {
        try {
            Turma turma = new Turma(codigo, professor);
            turmaDAO.save(turma);
            logService.salva("salvaTurma", "");
            return turma;
        } catch (Exception ex) {
            logService.salva("salvaTurma", ex.getMessage());
        }
        return null;
    }
}
