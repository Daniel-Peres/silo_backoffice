package br.com.silo.backoffice.service;

import br.com.silo.backoffice.dao.HistoricoDAO;
import br.com.silo.backoffice.domain.Equipamento;
import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.dto.HistoricoDTO;
import br.com.silo.backoffice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "historicoService")
public class HistoricoService {
    @Autowired
    HistoricoDAO historicoDAO;

    public Historico get(String datahora) {
        return historicoDAO.findByDate(datahora);
    }

    public Historico get(Long id) {
        Historico historico = historicoDAO.findById(id).orElse(null);
        if (historico == null) {
            throw new NotFoundException();
        }
        return historico;
    }

    public List<Historico> getGeral(long empresaId) {
        return historicoDAO.findGeral(empresaId);
    }

    public Page<Historico> get(String datahora, Integer pageSize, Integer page) {
        Pageable paging = PageRequest.of(page, pageSize);

        return historicoDAO.findPaged(datahora, paging);
    }

    public void saveHistorico(HistoricoDTO historicoDTO) {

    }

    public Historico getStatus(long empresaId,long veiculoId) {
        return historicoDAO.findStatus(empresaId, veiculoId);
    }
}
