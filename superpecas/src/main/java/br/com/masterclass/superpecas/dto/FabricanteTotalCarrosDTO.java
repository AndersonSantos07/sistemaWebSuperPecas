package br.com.masterclass.superpecas.dto;

public class FabricanteTotalCarrosDTO {

    private String fabricante;
    private Long totalCarros;

    public FabricanteTotalCarrosDTO(String fabricante, Long totalCarros) {
        this.fabricante = fabricante;
        this.totalCarros = totalCarros;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Long getTotalCarros() {
        return totalCarros;
    }

    public void setTotalCarros(Long totalCarros) {
        this.totalCarros = totalCarros;
    }
}
