package br.com.silo.backoffice.controller;

import br.com.silo.backoffice.domain.Equipamento;
import br.com.silo.backoffice.domain.dto.EquipamentoDTO;
import br.com.silo.backoffice.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {

    @Autowired
    EquipamentoService equipamentoService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public Page<Equipamento> getEquipamento(@RequestParam String codEquipamento, @RequestParam Integer pageSize, @RequestParam Integer page) {
//        return equipamentoService.get(codEquipamento, pageSize, page);
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Equipamento> getEquipamento(@RequestParam String codEquipamento, @RequestParam long empresaId, @RequestParam Integer pageSize, @RequestParam Integer page) {
        return equipamentoService.get(codEquipamento, empresaId, pageSize, page);
    }

    @RequestMapping(value = "/disabled", method = RequestMethod.GET)
    public List<Equipamento> getEquipamentoDisalbed(@RequestParam long empresaId) {
        return equipamentoService.getDisabled(empresaId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EquipamentoDTO getUserByID(@PathVariable Long id) {
        return EquipamentoDTO.converter(equipamentoService.get(id));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void post(@RequestBody EquipamentoDTO equipamento) {
        equipamentoService.saveEquipamento(equipamento);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public EquipamentoDTO put(@RequestBody EquipamentoDTO equipamento) {
        equipamentoService.updateEquipamento(equipamento);
        return equipamento;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        equipamentoService.deleteEquipamento(id);
    }

}