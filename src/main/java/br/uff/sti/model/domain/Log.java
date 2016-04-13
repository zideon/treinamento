/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author uff
 */
@Entity
public class Log implements Serializable {
    @Transient
    public static final String SUCESSO= "SUCESSO";
    @Transient
    public static final String FALHA= "FALHA";
    @Transient
    public static final String INFO= "INFO";
    
    @Id 
    @GeneratedValue
    private Long id ;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    @Temporal(TemporalType.TIME)
    private Date horario;
    
    private String operacao;
    
    private String valor;

    public Log() {}

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getOperacao() {
        return operacao;
    }

    public String getValor() {
        return valor;
    }

    public Date getHorario() {
        return horario;
    }
    public Log addData(Date data){
        this.data = data;
        return this;
    }
    public Log addOperacao(String operacao){
        this.operacao = operacao;
        return this;
     }
    public Log addValor(String valor){
        this.valor = valor;
        return this;
    }
}
