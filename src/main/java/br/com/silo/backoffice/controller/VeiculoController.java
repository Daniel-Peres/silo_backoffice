package br.com.silo.backoffice.controller;

import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.Veiculo;
import br.com.silo.backoffice.domain.dto.VeiculoDTO;
import br.com.silo.backoffice.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public Page<Veiculo> getVeiculos(@RequestParam String placaVeiculo, @RequestParam Integer pageSize, @RequestParam Integer page) {
//        return veiculoService.get(placaVeiculo, pageSize, page);
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Veiculo> getVeiculos(@RequestParam String placaVeiculo, @RequestParam long empresaId, @RequestParam Integer pageSize, @RequestParam Integer page) {
        return veiculoService.get(placaVeiculo, empresaId, pageSize, page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public VeiculoDTO getUserByID(@PathVariable Long id) {
        return VeiculoDTO.converter(veiculoService.get(id));
    }

    @RequestMapping(value = "/geral", method = RequestMethod.GET)
    public List<Veiculo> getGeral(@RequestParam long empresaId) {
        return veiculoService.getGeral(empresaId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void post(@RequestBody VeiculoDTO veiculo) {
        veiculoService.saveVeiculo(veiculo);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public VeiculoDTO put(@RequestBody VeiculoDTO veiculo) {
        veiculoService.updateVeiculo(veiculo);
        return veiculo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        veiculoService.deleteVeiculo(id);
    }
}
