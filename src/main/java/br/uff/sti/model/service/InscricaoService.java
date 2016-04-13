/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.service;

import br.uff.sti.model.dao.AlunoTurmaDAO;
import br.uff.sti.model.domain.AlunoTurma;
import br.uff.sti.model.domain.Log;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabio
 */
@Service
public interface InscricaoService extends DAOService<AlunoTurma>{

}
