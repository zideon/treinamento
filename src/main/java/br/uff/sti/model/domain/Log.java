/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author uff
 */
@Entity
public class Log implements Serializable {
    
    @Id 
    @GeneratedValue
    private Long id ;
    
    @Temporal(TemporalType.DATE)
    private java.util.Date data;
    
    private String operacao;
    
    private String valor;

    public Log() {}

    public Log(Date data, String operacao, String valor) {
        this.data = data;
        this.operacao = operacao;
        this.valor = valor;
    }

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
    
    
}
