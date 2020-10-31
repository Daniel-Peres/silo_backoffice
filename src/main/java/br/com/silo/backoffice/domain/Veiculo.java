package br.com.silo.backoffice.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(name = "modeloVeiculo")
    String modeloVeiculo;

    @Column(nullable = false)
    String placa_veiculo;

    @ManyToOne
    @JoinColumn(nullable = false)
    Empresa empresa;

    @OneToOne
    @JoinColumn
    Equipamento equipamento;

    @Column
    String numeroLinha;

    @Column
    Long totalLugares;

    @Column
    Long lugaresSentado;

    @Column
    Long lugaresEmPe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return placa_veiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placa_veiculo = placaVeiculo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(String numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    public Long getTotalLugares() {
        return totalLugares;
    }

    public void setTotalLugares(Long totalLugares) {
        this.totalLugares = totalLugares;
    }

    public Long getLugaresSentado() {
        return lugaresSentado;
    }

    public void setLugaresSentado(Long lugaresSentado) {
        this.lugaresSentado = lugaresSentado;
    }

    public Long getLugaresEmPe() {
        return lugaresEmPe;
    }

    public void setLugaresEmPe(Long lugaresEmPe) {
        this.lugaresEmPe = lugaresEmPe;
    }

}
