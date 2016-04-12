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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fabio
 */
@RestController
@RequestMapping(value = "/log")
public class LogController {
    @Autowired
    private LogService logService;
    
    @RequestMapping(value = "buscar/operacao/{operacao}", method = RequestMethod.GET)
    List<Log> buscarPorOperacao(@PathVariable String operacao) {
        return logService.buscaPorOperacao(operacao);
    }
    @RequestMapping(value = "buscar/valor/{valor}", method = RequestMethod.GET)
    List<Log> buscarPorValor(@PathVariable String valor) {
        return logService.buscaPorValor(valor);
    }
     @RequestMapping(value = "buscar/dataInicial/{dataInicial}/dataFinal/{dataFinal}", method = RequestMethod.GET)
    List<Log> buscarPorIntervaloData(@PathVariable String dataInicial, @PathVariable String dataFinal) {
        return logService.buscaIntervaloData(dataInicial, dataFinal);
    }
     @RequestMapping(value = "buscar/horarioInicial/{horarioInicial}/horarioFinal/{horarioFinal}", method = RequestMethod.GET)
    List<Log> buscarPorIntervaloHorario(@PathVariable String horarioInicial, @PathVariable String horarioFinal) {
        return logService.buscaIntervaloHorario(horarioInicial, horarioFinal);
    }
}
