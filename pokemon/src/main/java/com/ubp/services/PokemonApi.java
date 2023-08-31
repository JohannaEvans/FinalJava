package com.ubp.services;

import com.ubp.dto.PokemonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonApi {

    public List<PokemonDTO> obtenerPokemonApi();
    public PokemonDTO obtenerPokemonIdApi(Integer id);
    public void actualizarPokemonApi(PokemonDTO pokemonDTO, Integer id);
    public void guardarPokemonApi(PokemonDTO pokemonDTO);
    public void eliminarPokemonApi(Integer id);
}
