/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.LogDAO;
import br.uff.sti.model.domain.Log;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
@Service
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
        Log log = new Log(data, data, operacao, valor);
        return salva(log);
    }

    @Transactional
    public Log busca(Long id) {
        Log log = logDAO.findOne(id);
        return log;
    }
    @Transactional
    public List<Log> buscaPorOperacaoEValor(String operacao,String valor) {
        List<Log> logs = logDAO.findByOperacaoEValor(operacao, valor);
        return logs;
    }
   @Transactional
    public List<Log> buscaPorOperacao(String operacao) {
        List<Log> logs = logDAO.findByOperacao(operacao);
        return logs;
    }

    @Transactional
    public List<Log> buscaPorValor(String valor) {
        List<Log> logs = logDAO.findByValor(valor);
        return logs;
    }
    @Transactional
    public Iterable<Log> todos() {
        return logDAO.findAll();
    }
    
//    @Transactional
//    public List<Log> buscaIntervaloData(String dataInicial, String dataFinal) {
//        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
//        try {
//            Date d1 = df.parse(dataInicial);
//            Date d2 = df.parse(dataFinal);
//            List<Log> logs = logDAO.findByIntervaloData(d1, d2);
//            return logs;
//        } catch (ParseException ex) {
//            Logger.getLogger(LogService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Transactional
//    public List<Log> buscaIntervaloHorario(String horarioInicial, String horarioFinal) {
//        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
//        try {
//            Date d1 = df.parse(horarioInicial);
//            Date d2 = df.parse(horarioFinal);
//            List<Log> logs = logDAO.findByIntervaloHorario(d1, d2);
//            return logs;
//        } catch (ParseException ex) {
//            Logger.getLogger(LogService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
