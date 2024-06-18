package br.com.masterclass.superpecas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carros", indexes = {
        @Index(name = "idx_nome_modelo", columnList = "NomeModelo"),
        @Index(name = "idx_fabricante", columnList = "Fabricante")
})
public class CarrosModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarroID")
    private int carroID;

    @Column(name = "NomeModelo",nullable = false)
    private String nomeModelo;

    @Column(name = "Fabricante",nullable = false)
    private String fabricante;

    @Column(name ="CodigoUnico", nullable = false, unique = true)
    private String codigoUnico;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "carro", fetch = FetchType.LAZY)
    private Set<PecasModel> pecas = new HashSet<>();


    public int getCarroID() {
        return carroID;
    }

    public void setCarroID(int carroID) {
        this.carroID = carroID;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public Set<PecasModel> getPecas() {
        return pecas;
    }

    public void setPecas(Set<PecasModel> pecas) {
        this.pecas = pecas;
    }

    public String toString(){
        return "id: " + this.getCarroID() + " " +
                "modelo: " + this.getNomeModelo() + " " +
                "fabricante: " + this.getFabricante() + " " +
                "codigo único: " + this.getCodigoUnico();
    }
}
