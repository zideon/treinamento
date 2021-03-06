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
//@Table(name="cursos")
public class Curso implements Serializable {
    
    @Id
    private  String codigo;
    
    
    @Column ( name =" nome ",nullable = false)
    private  String nome;

    public Curso() {}


    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
    public Curso addNome(String nome){
        this.nome = nome;
        return this;
    }
    public Curso addCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
}
