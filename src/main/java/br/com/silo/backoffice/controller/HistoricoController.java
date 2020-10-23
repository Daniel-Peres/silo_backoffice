package br.com.silo.backoffice.controller;

import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.dto.HistoricoDTO;
import br.com.silo.backoffice.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/api/historico")
public class HistoricoController {
    @Autowired
    HistoricoService historicoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Historico> getHistorico(@RequestParam Date datahora, @RequestParam Integer pageSize, @RequestParam Integer page) {
        return historicoService.get(datahora, pageSize, page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HistoricoDTO getUserByID(@PathVariable Long id) {
        return HistoricoDTO.converter(historicoService.get(id));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void post(@RequestBody HistoricoDTO historico) {
        historicoService.saveHistorico(historico);
    }
}
