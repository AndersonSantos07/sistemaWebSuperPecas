package model;

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
    private int CarroID;

    @Column(nullable = false)
    private String NomeModelo;

    @Column(nullable = false)
    private String Fabricante;

    @Column(nullable = false, unique = true)
    private String CodigoUnico;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "carros", fetch = FetchType.LAZY)
    private Set<PecasModel> pecas = new HashSet<>();

    public int getCarroID() {
        return CarroID;
    }

    public void setCarroID(int carroID) {
        CarroID = carroID;
    }

    public String getNomeModelo() {
        return NomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        NomeModelo = nomeModelo;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String fabricante) {
        Fabricante = fabricante;
    }

    public String getCodigoUnico() {
        return CodigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        CodigoUnico = codigoUnico;
    }

    public Set<PecasModel> getPecas() {
        return pecas;
    }

    public void setPecas(Set<PecasModel> pecas) {
        this.pecas = pecas;
    }
}
