package com.ubp.controler;

import com.ubp.dto.PokemonDTO;
import com.ubp.services.PokemonApi;
import com.ubp.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiV1/Pokemon")
public class PokemonApiControler {


   @Autowired
   PokemonApi pokemonApi;

   @Autowired
   PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<PokemonDTO>>obtenerPokemonApi(){

        List<PokemonDTO> pokemonDTOS = pokemonApi.obtenerPokemonApi();
        for (PokemonDTO pokemonDTO : pokemonDTOS) {
            pokemonService.guardarPokemon(pokemonDTO);

        }
        return new ResponseEntity<>(pokemonApi.obtenerPokemonApi(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> obtenerPokemonIdApi(@PathVariable(name="id")Integer id){
        return new ResponseEntity<>(pokemonApi.obtenerPokemonIdApi(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarPokemonApi(@RequestBody PokemonDTO pokemonDTO) {
        pokemonApi.guardarPokemonApi(pokemonDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actualizarPokemonApi(@PathVariable(name = "id") Integer id, @RequestBody PokemonDTO pokemonDTO) {
        pokemonApi.actualizarPokemonApi(pokemonDTO, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarPokemonApi(@PathVariable(name = "id") Integer id) {
        pokemonApi.eliminarPokemonApi(id);
    }

}
