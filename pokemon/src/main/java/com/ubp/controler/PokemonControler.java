package com.ubp.controler;

import com.ubp.dto.PokemonDTO;
import com.ubp.dto.PokemonRespDTO;
import com.ubp.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/apiV1/Pokemon2")
public class PokemonControler {

    @Autowired
    PokemonService pokemonService;

    @GetMapping
    public PokemonRespDTO obtenerPokemon(
            @RequestParam(value="PagNo", defaultValue="0", required=false)int numeroDePagina,
            @RequestParam(value="PageSize", defaultValue="10", required=false)int tamañoDePagina){

        return pokemonService.obtenerPokemon(numeroDePagina,tamañoDePagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> obtenerPokemonPorId(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(pokemonService.obtenerPokemonPorId(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> guardarPokemon(@RequestBody PokemonDTO pokemonDTO) {
        pokemonService.guardarPokemon(pokemonDTO);
        return new ResponseEntity<>("Pokemon guardado", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PokemonDTO> actualizarPokemon(@PathVariable(name = "id") Integer id, @RequestBody PokemonDTO pokemonDTO) {
        pokemonService.actualizarPokemon(pokemonDTO, id);
        return new ResponseEntity<>(pokemonService.actualizarPokemon(pokemonDTO,id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> eliminarPokemon(@PathVariable(name = "id") Integer id) {
        pokemonService.eliminarPokemon(id);
        return new ResponseEntity<>("Pokemon eliminado", HttpStatus.OK);
    }

}

