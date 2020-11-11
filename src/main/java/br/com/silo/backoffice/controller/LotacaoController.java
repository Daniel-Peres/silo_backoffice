package br.com.silo.backoffice.controller;

import br.com.silo.backoffice.domain.dto.HistoricoDTO;
import br.com.silo.backoffice.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/device/api/lotacao")
public class LotacaoController {

    @Autowired
    HistoricoService historicoService;

    @RequestMapping(value = "/measure", method = RequestMethod.POST)
    public void post(@RequestBody String data) {
        System.out.println(data);
        historicoService.saveHistorico(data);
    }
}
