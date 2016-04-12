/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.dao;

import br.uff.sti.model.domain.Log;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author uff
 */
public interface LogDAO extends CrudRepository<Log,Long>{
    
//    
//    @Query("SELECT lg FROM Log lg \n" +
//    "WHERE lg.data BETWEEN ?1 AND ?2")
//    public  List<Log> findByIntervaloData(Date dataInicial,Date dataFinal);
//    @Query("SELECT lg FROM Log lg \n" +
//    "WHERE TIMElg.horario BETWEEN ?1 AND ?2")
//    public  List<Log> findByIntervaloHorario(Date horarioInicial,Date horarioFinal);
    
    @Query("SELECT lg From Log lg WHERE lg.operacao=?1")
    public  List<Log> findByOperacao(String operacao);
    @Query("SELECT lg From Log lg WHERE lg.valor=?1")
    public  List<Log> findByValor(String valor);
    @Query("SELECT lg From Log lg WHERE lg.operacao=?1 AND lg.valor=?2")
    public  List<Log> findByOperacaoEValor(String operacao,String valor);
  
}
