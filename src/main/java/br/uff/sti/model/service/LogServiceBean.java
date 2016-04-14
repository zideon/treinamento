/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.LogDAO;
import br.uff.sti.model.domain.Log;
import java.util.Date;
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
public class LogServiceBean implements LogService{
    @Autowired
    private LogDAO logDAO;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public Log salva(Log log) {
        logDAO.save(log);
        return log;
    } 

 
    public Log busca(Long id) {
        Log log = logDAO.findOne(id);
        return log;
    }
   
    
    public Iterable<Log> todos() {
        return logDAO.findAll();
    }
    

    @Override
    public Log busca(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Log> buscaPorAtributos(Log modelo) {
        String operacao = modelo.getOperacao();
        String valor = modelo.getValor();
        if(operacao!=null && valor==null){
            return logDAO.findByOperacao(operacao);
        }else if(operacao==null && valor!=null){
           return logDAO.findByValor(valor);
        }else if(operacao!=null && valor!=null){
            return logDAO.findByOperacaoEValor(operacao, valor);
        }
        return null;
    }

    @Override
    public Log cria(Object... objs) {
         Date data = new Date(System.currentTimeMillis());
            Log log = new Log()
                    .addData(data)
                    .addOperacao((String)objs[0])
                    .addValor((String)objs[1]);
        return log;
    }
}
