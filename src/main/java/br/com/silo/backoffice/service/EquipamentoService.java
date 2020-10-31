package br.com.silo.backoffice.service;

import br.com.silo.backoffice.dao.EquipamentoDAO;
import br.com.silo.backoffice.domain.Equipamento;
import br.com.silo.backoffice.domain.dto.EquipamentoDTO;
import br.com.silo.backoffice.exception.BadRequestException;
import br.com.silo.backoffice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "equipamentoService")
public class EquipamentoService {
    @Autowired
    EquipamentoDAO equipamentoDAO;

    public Equipamento get(String codEquipamento) {
        return equipamentoDAO.findByUsername(codEquipamento);
    }

    public Equipamento get(Long id) {
        Equipamento equipamento = equipamentoDAO.findById(id).orElse(null);
        if (equipamento == null) {
            throw new NotFoundException();
        }
        return equipamento;
    }

    public Page<Equipamento> get(String codEquipamento, Integer pageSize, Integer page) {
        Pageable paging = PageRequest.of(page, pageSize);

        return equipamentoDAO.findPaged(codEquipamento, paging);
    }

    public List<Equipamento> getDisabled(long empresaId) {
        return equipamentoDAO.findDisabled(empresaId);
    }

    public void saveEquipamento(EquipamentoDTO equipamentoDTO) {

        Boolean valid = isValidEquipamento(equipamentoDTO.getCodEquipamento(), 0L);
        if (!valid) {
            throw new BadRequestException("Já existe um Equipamento com este código.");
        }

        Equipamento equipamento = new Equipamento();
        equipamento.setId(equipamentoDTO.getId());
        equipamento.setCodEquipamento(equipamentoDTO.getCodEquipamento());
        equipamento.setEmpresa(equipamentoDTO.getEmpresa());
        equipamento.setDescricaoEquipamento(equipamentoDTO.getDescricaoEquipamento());
        equipamento.setStatusEquipamento(equipamentoDTO.getStatusEquipamento());

        equipamentoDAO.save(equipamento);
    }

    public void updateEquipamento(EquipamentoDTO equipamentoDTO) {

        Boolean valid = isValidEquipamento(equipamentoDTO.getCodEquipamento(), equipamentoDTO.getId());
        if (!valid) {
            throw new BadRequestException("Já existe um Equipamento com este código.");
        }

        Equipamento equipamento = equipamentoDAO.findById(equipamentoDTO.getId()).orElse(null);

        //Verifica se Equipamento existe.
        if (equipamento == null) {
            throw new NotFoundException();
        }


        equipamento.setCodEquipamento(equipamentoDTO.getCodEquipamento());

        equipamento.setCodEquipamento(equipamentoDTO.getCodEquipamento());
        equipamento.setEmpresa(equipamentoDTO.getEmpresa());
        equipamento.setDescricaoEquipamento(equipamentoDTO.getDescricaoEquipamento());
        equipamento.setStatusEquipamento(equipamentoDTO.getStatusEquipamento());

        equipamentoDAO.save(equipamento);
    }

    public Boolean isValidEquipamento(String codEquipamento, Long id) {
        Equipamento equipamento = equipamentoDAO.findByUsername(codEquipamento);

        if (equipamento == null)
            return true;

        if (id != 0) {
            return equipamento.getId().equals(id);
        } else {
            return false;
        }
    }

    public void deleteEquipamento(Long id) {
        Equipamento equipamento = equipamentoDAO.findById(id).orElse(null);

        //Verifica se usuário existe.
        if (equipamento == null) {
            throw new NotFoundException();
        }

        String status = equipamento.getStatusEquipamento();

        if (status == "ATIVO") {
            throw new BadRequestException("Não é possível excluir um equipamento ativo.");
        }
        equipamentoDAO.delete(equipamento);
    }
}
