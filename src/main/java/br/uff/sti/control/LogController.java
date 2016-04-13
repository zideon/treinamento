/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.control;

import br.uff.sti.model.domain.Log;
import br.uff.sti.model.service.LogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author fabio
 */
@RestController
@RequestMapping(value = "/log")
public class LogController {
    @Autowired
    private LogService logService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<Iterable<Log>> todos() {
        return new ResponseEntity<>(logService.todos(),HttpStatus.OK);
    }
    
    @RequestMapping(value = "busca/", method = RequestMethod.GET)
    ResponseEntity<List<Log>> buscar(
            @RequestParam(value = "operacao",required = false) String operacao,
            @RequestParam(value = "valor",required = false) String valor
    ) {
        Log log = new Log().addOperacao(operacao).addValor(valor);
        List<Log> logs = logService.buscaPorAtributos(log);
        if(logs==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }
    
//     @RequestMapping(value = "buscar/dataInicial/{dataInicial}/dataFinal/{dataFinal}", method = RequestMethod.GET)
//    List<Log> buscarPorIntervaloData(@PathVariable String dataInicial, @PathVariable String dataFinal) {
//        return logService.buscaIntervaloData(dataInicial, dataFinal);
//    }
//     @RequestMapping(value = "buscar/horarioInicial/{horarioInicial}/horarioFinal/{horarioFinal}", method = RequestMethod.GET)
//    List<Log> buscarPorIntervaloHorario(@PathVariable String horarioInicial, @PathVariable String horarioFinal) {
//        return logService.buscaIntervaloHorario(horarioInicial, horarioFinal);
//    }
}
