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
public class AlunoTurma implements Serializable{
    @Id 
    @GeneratedValue
    private Long id ;
    @JoinColumn(name = "cod_aluno",nullable = false)
    @ManyToOne
    private Aluno aluno;
    @JoinColumn(name = "cod_turma",nullable = false)
    @ManyToOne
    private Turma turma;

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public AlunoTurma() {
    }

    public AlunoTurma(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }
    
    
}
