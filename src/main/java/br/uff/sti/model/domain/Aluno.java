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
//@Table(name="alunos")
public class Aluno implements Serializable {

    
    @Id
    private String matricula;
    
    private String nome;
    
    @JoinColumn(name = "cod_curso")
    @ManyToOne
    private Curso curso;

    public Aluno() {}

    public Aluno(String matricula, String nome, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }

}
