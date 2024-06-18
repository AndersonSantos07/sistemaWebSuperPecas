package br.com.masterclass.superpecas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pecas", indexes = {
        @Index(name = "idx_numero_serie", columnList = "NumeroSerie"),
        @Index(name = "idx_modelo_carro", columnList = "ModeloCarro")
})
public class PecasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PecaId")
    private int pecaId;

    @Column(name ="Nome",nullable = false)
    private String nome;

    @Column(name = "Descricao",nullable = false)
    private String descricao;

    @Column(name = "NumeroSerie",nullable = false, unique = true)
    private String numeroSerie;

    @Column(name = "Fabricante",nullable = false)
    private String fabricante;

    @Column(name = "ModeloCarro",nullable = false)
    private String modeloCarro;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CarroID")
    private CarrosModel carro;

    public int getPecaId() {
        return pecaId;
    }

    public void setPecaId(int pecaId) {
        this.pecaId = pecaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public CarrosModel getCarro() {
        return carro;
    }

    public void setCarro(CarrosModel carro) {
        this.carro = carro;
    }
}
