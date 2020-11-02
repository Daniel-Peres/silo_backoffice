package br.com.silo.backoffice.domain.dto;

import br.com.silo.backoffice.domain.Equipamento;
import br.com.silo.backoffice.domain.Historico;
import br.com.silo.backoffice.domain.Veiculo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class HistoricoDTO {
    Long id;

    Veiculo veiculo;

    String datahora;

    Long qtdPassageiros;

    String status;

    Equipamento equipamento;

    public static HistoricoDTO converter(Historico historico) {
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setId(historico.getId());
        historicoDTO.setVeiculo(historico.getVeiculo());
        historicoDTO.setEquipamento(historico.getEquipamento());
        historicoDTO.setDatahora(historico.getDatahora());
        historicoDTO.setQtdPassageiros(historico.getQtdPassageiros());
        historicoDTO.setId(historico.getQtdPassageiros());
        return historicoDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public Long getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(Long qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
