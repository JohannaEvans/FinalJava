package com.ubp.services;

import com.ubp.dto.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class PokemonApiIMP implements PokemonApi {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL_BASE = "https://64daaac0e947d30a260b76b2.mockapi.io/apiExt/Pokemon/";

    @Override
    public List<PokemonDTO> obtenerPokemonApi() {
        PokemonDTO[] pokemonDTOS = restTemplate.getForObject(URL_BASE, PokemonDTO[].class);
        return Arrays.asList(pokemonDTOS);
    }

    @Override
    public PokemonDTO obtenerPokemonIdApi(Integer id) {
        PokemonDTO pokemonDTO = restTemplate.getForObject(URL_BASE + id, PokemonDTO.class);
        return pokemonDTO;
    }

    @Override
    public void actualizarPokemonApi(PokemonDTO pokemonDTO, Integer id) {
        restTemplate.put(URL_BASE + id, pokemonDTO, PokemonDTO.class);
    }

    @Override
    public void guardarPokemonApi(PokemonDTO pokemonDTO) {
        restTemplate.postForObject(URL_BASE,pokemonDTO ,PokemonDTO.class);
    }

    @Override
    public void eliminarPokemonApi(Integer id) {
        restTemplate.delete(null);
    }
}


