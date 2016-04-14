/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.model.servicesTest;

import br.uff.sti.AbstractTest;
import br.uff.sti.model.domain.Aluno;
import br.uff.sti.model.domain.Curso;
import br.uff.sti.model.service.AlunoService;
import br.uff.sti.model.service.CursoService;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author fabio
 */
@Transactional
public class AlunoServiceTest extends AbstractTest{
    
    @Autowired
    private AlunoService alunoService;
     @Autowired
    private CursoService cursoService;
    @Before
    public void setUp(){
        for (int i = 0; i < 10; i++) { 
            cursoService.salva(cursoService.cria(""+i,"comp"+i));
        }
         for (int i = 0; i < 10; i++) {
            alunoService.salva(alunoService.cria(""+i,"fabio"+i,""+i)); 
        }
    }
    @After
    public void tearDown(){
        //clean up after the test
    }
    @Test
    public void salvaTest(){
        Iterable<Aluno> list = alunoService.todos();
        Assert.assertNotNull("Esperado uma lista não nula", list);
        Assert.assertEquals("Experado uma lista com 10 elementos ", 10, ((Collection<?>)list).size());
        Aluno novo = new Aluno()
                .addMatricula("212031100")
                .addNome("fabio")
                .addCurso(cursoService.busca("1"));
        alunoService.salva(novo);
        list = alunoService.todos();
        Assert.assertEquals("Experado uma lista com 11 elementos ", 11, ((Collection<?>)list).size());
    }
    @Test
    public void criaTest(){
        
    }
    @Test
    public void buscaTest(){
        
    }
}
