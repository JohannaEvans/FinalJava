package com.ubp.services;

import com.ubp.dto.PokemonDTO;
import com.ubp.dto.PokemonRespDTO;
import org.springframework.stereotype.Service;


@Service
public interface PokemonService {

    public PokemonRespDTO obtenerPokemon(int numeroDePagina, int tamañoDePagina);
    public PokemonDTO obtenerPokemonPorId(Integer id);
    public PokemonDTO actualizarPokemon(PokemonDTO pokemonDTO, Integer id);
    public PokemonDTO guardarPokemon(PokemonDTO pokemonDTO);
    public void eliminarPokemon(Integer id);

}
