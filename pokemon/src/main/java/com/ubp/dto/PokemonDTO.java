package com.ubp.dto;

import lombok.Data;

@Data
public class PokemonDTO {
    private Integer id;
    private String pokemon;
    private String url;
    private String imageUrl;

    public PokemonDTO(Integer id,String pokemon, String url, String imageUrl) {
        super();
        this.id = id;
        this.pokemon = pokemon;
        this.url = url;
        this.imageUrl = imageUrl;


    }

    public PokemonDTO() {

    }

    @Override
    public String toString() {
        return "PokemonDTO [id = " + id + " ,pokemon=" + pokemon + ", url=" + url + ", imageUrl=" + imageUrl + "]";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

 }

