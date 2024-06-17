package model;

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
    private int PecaId;

    @Column(nullable = false)
    private String Nome;

    @Column(nullable = false)
    private String Descricao;

    @Column(nullable = false, unique = true)
    private String NumeroSerie;

    @Column(nullable = false)
    private String Fabricante;

    @Column(nullable = false)
    private String ModeloCarro;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CarroID")
    private CarrosModel carro;

    public int getPecaId() {
        return PecaId;
    }

    public void setPecaId(int pecaId) {
        PecaId = pecaId;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String fabricante) {
        Fabricante = fabricante;
    }

    public String getModeloCarro() {
        return ModeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        ModeloCarro = modeloCarro;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        NumeroSerie = numeroSerie;
    }

    public CarrosModel getCarro() {
        return carro;
    }

    public void setCarros(CarrosModel carro) {
        this.carro = carro;
    }
}
