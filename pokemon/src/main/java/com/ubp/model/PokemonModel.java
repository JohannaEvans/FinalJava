package com.ubp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@Entity
@Table(name="Pokemon",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pokemon"})})

    public class PokemonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String pokemon;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String imageUrl;

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

    @Override
    public String toString() {
        return "PokemonModel [id = " + id + ", pokemon=" + pokemon + ", url=" + url + ", imageUrl=" + imageUrl + "]";
    }

    public PokemonModel(Integer id,String pokemon, String url, String imageUrl ) {
        super();
        this.id = id;
        this.pokemon = pokemon;
        this.url = url;
        this.imageUrl = imageUrl;

    }

}
