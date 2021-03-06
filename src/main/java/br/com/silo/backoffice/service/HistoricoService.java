package br.com.silo.backoffice.service;

import br.com.silo.backoffice.dao.HistoricoDAO;
import br.com.silo.backoffice.dao.VeiculoDAO;
import br.com.silo.backoffice.domain.Equipamento;
import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.Veiculo;
import br.com.silo.backoffice.domain.dto.HistoricoDTO;
import br.com.silo.backoffice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service(value = "historicoService")
public class HistoricoService {
    @Autowired
    HistoricoDAO historicoDAO;

    @Autowired
    VeiculoDAO veiculoDAO;

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

//    public Page<Historico> get(String datahora, Integer pageSize, Integer page) {
//        Pageable paging = PageRequest.of(page, pageSize);
//
//        return historicoDAO.findPaged(datahora, paging);
//    }

    public Page<Historico> get(String datahora, long empresaId,  Integer pageSize, Integer page) {
        Pageable paging = PageRequest.of(page, pageSize);

        return historicoDAO.findPaged(datahora, empresaId, paging);
    }

    public void saveHistorico(String data) {
        if(data.length() >= 3) {
            if(data.contains(";")) {
                String[] measureData = data.split(";");
                Long vehicle = Long.valueOf(measureData[0]);
                Long qty = Long.valueOf(measureData[1]);

                Veiculo veiculo = veiculoDAO.findByID(vehicle);

                if(veiculo != null) {
                    if (veiculo.getEquipamento() != null) {
                        Historico historico = new Historico();

                        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
                        String date = fmt.format(new Date());

                        historico.setDatahora(date);
                        historico.setEquipamento(veiculo.getEquipamento());
                        historico.setQtdPassageiros(qty);
                        historico.setVeiculo(veiculo);

                        double indiceBaixo = veiculo.getTotalLugares() * 0.33;
                        double indiceMedio = veiculo.getTotalLugares() * 0.66;

                        if (qty < indiceBaixo) {
                            if(historico.getQtdPassageiros() == 0) historico.setStatus("Lotação - Vazio");
                            else historico.setStatus("Lotação - Baixa");
                        }
                        else if (qty < indiceMedio){ historico.setStatus("Lotação - Média"); }
                        else {
                            if(historico.getQtdPassageiros() >= veiculo.getTotalLugares()) historico.setStatus("Lotação - Máxima");
                            else historico.setStatus("Lotação - Alta");
                        }

                        historicoDAO.save(historico);
                    } else {
                        System.out.println("Veículo sem equipamento alocado!");
                    }
                } else {
                    System.out.println("Veículo não encontrado!");
                }
            }
        }
    }

    public Historico getStatus(long empresaId,long veiculoId) {
        return historicoDAO.findStatus(empresaId, veiculoId);
    }
}
