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
    
    @JoinColumn(name = "cod_curso",nullable = false)
    @ManyToOne
    private Curso curso;

    public Aluno() {}

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }
    public Aluno addMatricula(String matricula){
        this.matricula= matricula;
        return this;
    }
    public Aluno addNome(String nome){
        this.nome= nome;
        return this;
    }
    public Aluno addCurso(Curso curso){
        this.curso= curso;
        return this;
    }
}
