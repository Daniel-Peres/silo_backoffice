package br.com.silo.backoffice.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/device/api/lotacao")
public class LotacaoController {
    @RequestMapping(value = "/measure", method = RequestMethod.POST)
    public void post(@RequestBody String data) {
        System.out.println(data);
    }
}
