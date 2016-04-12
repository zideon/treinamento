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
public class InscricaoService {

    @Autowired
    private AlunoTurmaDAO alunoTurmaDAO;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private LogService logService;

    @Transactional
    public AlunoTurma salva(AlunoTurma alunoTurma) {
        try {
            alunoTurmaDAO.save(alunoTurma);
            logService.salva("salvaAlunoTurma", Log.SUCESSO);
            return alunoTurma;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Transactional
    public AlunoTurma salva(String matriculaAluno, String codigoTurma) {

        AlunoTurma alunoTurma = new AlunoTurma(alunoService.busca(matriculaAluno),
                turmaService.busca(codigoTurma));
        alunoTurma= salva(alunoTurma);
        if(alunoTurma==null){
            logService.salva("salvaAlunoTurma", Log.FALHA);
        }
        return alunoTurma;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<AlunoTurma> buscarPorAlunoETurma(String matriculaAluno ,String codigoTurma) {

        List<AlunoTurma> lista = alunoTurmaDAO.findByMatriculaDoAlunoECodigoDaTurma(matriculaAluno, codigoTurma);
        return confirirLista(lista);
    }
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<AlunoTurma> buscarPorTurma(String codigoTurma) {

        List<AlunoTurma> lista = alunoTurmaDAO.findByCodigoDaTurma(codigoTurma);
        return confirirLista(lista);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<AlunoTurma> buscarPorAluno(String matriculaAluno) {

        List<AlunoTurma> lista = alunoTurmaDAO.findByMatriculaDoAluno(matriculaAluno);
        return confirirLista(lista);
    }

    private List<AlunoTurma> confirirLista(List<AlunoTurma> lista) {
        try {
            if (lista == null) {
                throw new Exception("");
            }
            logService.salva("buscaInscricao", Log.SUCESSO);
            return lista;
        } catch (Exception ex) {
            logService.salva("buscaInscricao", Log.FALHA);
        }
        return null;
    }
    @Transactional
    public Iterable<AlunoTurma> todos() {

        return alunoTurmaDAO.findAll();
    }
}
