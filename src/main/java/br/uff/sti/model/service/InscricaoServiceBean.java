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
 * @author uff
 */
@Service
public class InscricaoServiceBean implements InscricaoService {
    
    @Autowired
    private AlunoTurmaDAO alunoTurmaDAO;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private LogService logService;


    public AlunoTurma salva(AlunoTurma alunoTurma) {
       alunoTurma = salvaT(alunoTurma);
       if(alunoTurma==null){
           logService.salva(logService.cria("salvaAlunoTurma", Log.SUCESSO));
       }
       return alunoTurma;
    }
    @Transactional
    public AlunoTurma salvaT(AlunoTurma alunoTurma) {
        try {
            alunoTurmaDAO.save(alunoTurma);
            logService.salva(logService.cria("salvaAlunoTurma", Log.SUCESSO));
            return alunoTurma;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    
    private List<AlunoTurma> confirirLista(List<AlunoTurma> lista) {
        try {
            if (lista == null) {
                throw new Exception("");
            }
            logService.salva(logService.cria("buscaInscricao", Log.SUCESSO));
            return lista;
        } catch (Exception ex) {
            logService.salva(logService.cria("buscaInscricao", Log.FALHA));
        }
        return null;
    }
    @Transactional
    public Iterable<AlunoTurma> todos() {

        return alunoTurmaDAO.findAll();
    }

    @Override
    public AlunoTurma busca(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoTurma cria(Object... objs) {
        AlunoTurma alunoTurma = new AlunoTurma(alunoService.busca((String)objs[0]),
                turmaService.busca((String)objs[1]));
        return alunoTurma;
    }

    @Override
    @Transactional
    public List<AlunoTurma> buscaPorAtributos(AlunoTurma modelo) {
        String matricula = modelo.getAluno().getMatricula();
        String codigo = modelo.getTurma().getCodigo();
        if(codigo!= null && matricula==null){
            return alunoTurmaDAO.findByCodigoDaTurma(codigo);
        }else if(codigo== null && matricula!=null){
            return alunoTurmaDAO.findByMatriculaDoAluno(matricula);
        }else if(codigo!= null && matricula!=null){
            return alunoTurmaDAO.findByMatriculaDoAlunoECodigoDaTurma(
                  matricula, codigo);
        }
        return null;
    }
}
