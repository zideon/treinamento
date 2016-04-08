/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author uff
 */
@Entity
//@Table(name="turmas")
public class Turma implements Serializable {
    @Id
    private String codigo;
    
    private String professor;
    
    public String getCodigo() {
        return codigo;
    }

    public Turma() {
    }
    
    public Turma(String codigo, String professor) {
        this.codigo = codigo;
        this.professor = professor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
