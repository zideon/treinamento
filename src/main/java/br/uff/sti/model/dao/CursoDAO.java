/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.dao;

import br.uff.sti.model.domain.Curso;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author uff
 */
public interface CursoDAO extends CrudRepository<Curso,String>{
    
}
