package br.com.masterclass.superpecas.dto;

public class FabricanteDTO {
    private String fabricante;

    public FabricanteDTO(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

}
