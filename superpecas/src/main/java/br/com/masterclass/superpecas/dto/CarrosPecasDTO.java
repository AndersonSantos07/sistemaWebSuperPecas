package br.com.masterclass.superpecas.dto;

public class CarrosPecasDTO {

    private String nomeModelo;
    private Long quantidadePecas;

    public CarrosPecasDTO(String nomeModelo, Long quantidadePecas) {
        this.nomeModelo = nomeModelo;
        this.quantidadePecas = quantidadePecas;
    }

    public CarrosPecasDTO() {
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public Long getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(Long quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }
}
