/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.LogDAO;
import br.uff.sti.model.domain.Log;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
public class LogService {
    @Autowired
    private LogDAO logDAO;
    
    @Transactional
    public Log salva(Log log) {
        logDAO.save(log);
        return log;
    }
    @Transactional
    public Log salva(String operacao, String valor) {
        Date data = new Date(System.currentTimeMillis());
        Log log = new Log(data, operacao, valor);
        logDAO.save(log);
        return log;
    }
}
