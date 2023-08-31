package com.ubp.dto;

import java.util.List;
import lombok.Data;

@Data
public class PokemonRespDTO {

    private List<PokemonDTO> contenido;
    private int numeroPagina;
    private int tamañoPagina;
    private Long cantidadElementos;
    private int cantidadPaginas;
    private Boolean ultima;


    @Override
    public String toString() {
        return "PokemonRespDTO [contenido=" + contenido + ", numeroPagina=" + numeroPagina + ", tamañoPagina="
                + tamañoPagina + ", cantidadElementos=" + cantidadElementos + ", cantidadPaginas=" + cantidadPaginas
                + ", ultima=" + ultima + "]";
    }

    public List<PokemonDTO> getContenido() {
        return contenido;
    }

    public void setContenido(List<PokemonDTO> contenido) {
        this.contenido = contenido;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getTamañoPagina() {
        return tamañoPagina;
    }

    public void setTamañoPagina(int tamañoPagina) {
        this.tamañoPagina = tamañoPagina;
    }

    public Long getCantidadElementos() {
        return cantidadElementos;
    }

    public void setCantidadElementos(Long cantidadElementos) {
        this.cantidadElementos = cantidadElementos;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Boolean getUltima() {
        return ultima;
    }

    public void setUltima(Boolean ultima) {
        this.ultima = ultima;
    }

}
