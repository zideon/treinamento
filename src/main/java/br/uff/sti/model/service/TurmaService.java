/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.LogDAO;
import br.uff.sti.model.dao.TurmaDAO;
import br.uff.sti.model.domain.Log;
import br.uff.sti.model.domain.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uff
 */
@Service
public interface TurmaService extends DAOService<Turma> {

    
}
