/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.dao;

import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Turma;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author uff
 */
public interface AlunoTurmaDAO extends CrudRepository<AlunoTurma,String>{
    
    
    public  List<AlunoTurma> findByTurma(Turma turma);
    
    public  List<AlunoTurma> findByAluno(Aluno aluno);
    
    @Query("SELECT atu FROM AlunoTurma atu "
            + " INNER JOIN FETCH atu.aluno al "
            + " INNER JOIN FETCH atu.turma t "
            + " WHERE t.codigo = ?1")
    public  List<AlunoTurma> findByCodigoDaTurma(String codigo);
    
    @Query("SELECT atu FROM AlunoTurma atu "
            + " INNER JOIN FETCH atu.aluno al "
            + " INNER JOIN FETCH atu.turma t "
            + " WHERE al.matricula = ?1")
    public List<AlunoTurma> findByMatriculaDoAluno(String matricula);
    
    @Query("SELECT atu FROM AlunoTurma atu "
            + " INNER JOIN FETCH atu.aluno al "
            + " INNER JOIN FETCH atu.turma t "
            + " WHERE al.matricula = ?1 AND t.codigo = ?2")
    public List<AlunoTurma> findByMatriculaDoAlunoECodigoDaTurma(String matricula,String codigo);
}
