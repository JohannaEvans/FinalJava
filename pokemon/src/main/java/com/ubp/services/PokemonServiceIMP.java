package com.ubp.services;

import com.ubp.dto.PokemonDTO;
import com.ubp.dto.PokemonRespDTO;
import com.ubp.exception.PokemonException;
import com.ubp.model.PokemonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ubp.repository.PokemonRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class PokemonServiceIMP implements PokemonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonServiceIMP.class);

    @Autowired
    private PokemonRepository pokemonRepository;

    private PokemonModel mapDTO(PokemonDTO pokemonDTO) {
        PokemonModel pokemonModel = new PokemonModel();
        pokemonModel.setPokemon(pokemonDTO.getPokemon());
        pokemonModel.setUrl(pokemonDTO.getUrl());
        pokemonModel.setImageUrl(pokemonDTO.getImageUrl());
        return pokemonModel;
    }

    private PokemonDTO map(PokemonModel pokemonModel) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemonModel.getId());
        pokemonDTO.setPokemon(pokemonModel.getPokemon());
        pokemonDTO.setUrl(pokemonModel.getUrl());
        pokemonDTO.setImageUrl(pokemonModel.getImageUrl());
        return pokemonDTO;
    }


    @Override
    public PokemonRespDTO obtenerPokemon(int numeroPagina, int TamañoDePagina) {
        Pageable pageable = (Pageable) PageRequest.of(numeroPagina, TamañoDePagina);
        Page<PokemonModel> pokemonModels = pokemonRepository.findAll(pageable);
        List<PokemonModel> pokemonModelList = pokemonModels.getContent();

        List<PokemonDTO> contenido = new ArrayList<>();

        for (PokemonModel pokemonModel : pokemonModelList) {
            contenido.add(map(pokemonModel));
        }

        PokemonRespDTO pokemonRespDTO = new PokemonRespDTO();

        pokemonRespDTO.setContenido(contenido);
        pokemonRespDTO.setCantidadPaginas(pokemonModels.getTotalPages());
        pokemonRespDTO.setTamañoPagina(pokemonModels.getSize());
        pokemonRespDTO.setCantidadElementos((pokemonModels.getTotalElements()));
        pokemonRespDTO.setNumeroPagina(pokemonModels.getNumber());
        pokemonRespDTO.setUltima(pokemonModels.isLast());

        return pokemonRespDTO;
    }

    @Override
    public PokemonDTO obtenerPokemonPorId(Integer id) {
        PokemonModel pokemonModel = pokemonRepository.findById(id).orElseThrow(() ->  new PokemonException("pokemon","id",id));
        return map(pokemonModel);
    }

    @Override
    public PokemonDTO actualizarPokemon(PokemonDTO pokemonDTO, Integer id) {
        PokemonModel pokemonModel =  pokemonRepository.findById(id).orElseThrow(() ->  new PokemonException("pokemon","id",id));
        pokemonModel.setPokemon(pokemonDTO.getPokemon());
        pokemonModel.setUrl(pokemonDTO.getUrl());
        pokemonModel.setImageUrl(pokemonDTO.getImageUrl());
        PokemonModel pokemonModels = pokemonRepository.save(pokemonModel);
        return map(pokemonModel);
       }

    @Override
    public PokemonDTO guardarPokemon(PokemonDTO pokemonDTO) {
        PokemonModel pokemonModel =  mapDTO(pokemonDTO);
        PokemonModel pokemonNew = pokemonRepository.save(pokemonModel);
        PokemonDTO pokemonDTOs = map(pokemonNew);
        return pokemonDTOs;
    }


    @Override
    public void eliminarPokemon(Integer id) {
        PokemonModel pokemonModel = pokemonRepository.findById(id).orElseThrow(() ->  new PokemonException("pokemon","id",id));
        pokemonRepository.delete(pokemonModel);

    }
}


