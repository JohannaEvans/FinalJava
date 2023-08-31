package com.ubp.pokemon.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ubp.dto.PokemonDTO;
import com.ubp.dto.PokemonRespDTO;

import com.ubp.model.PokemonModel;
import com.ubp.repository.PokemonRepository;

import com.ubp.services.PokemonServiceIMP;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PokemonTests {

	@Mock
	private PokemonRepository pokemonRepository;

	@InjectMocks
	private PokemonServiceIMP pokemonServiceIMP;


	private PokemonModel pokemonModel;
	private PokemonDTO pokemonDTO;

	@BeforeEach
	void setup() {
		 pokemonModel = new PokemonModel( 1,"pokemon generico", "url generico" , "imageUrl generico");
		 pokemonDTO = new PokemonDTO(1,"pokemon generico","url generica","imageUrl generico");
	}



	@DisplayName("Test para obtener pokemon por id")
	@Test
	void testObtenerPokemonPorId() {
		given(pokemonRepository.findById(pokemonModel.getId())).willReturn(Optional.of(pokemonModel));
		PokemonDTO pokemonDTO = pokemonServiceIMP.obtenerPokemonPorId(1);
		assertThat(pokemonDTO).isNotNull();

	}



	@DisplayName("Test para guardar pokemon")
	@Test
	void testGuardarPokemon() {
		given(pokemonRepository.save(pokemonModel)).willReturn(pokemonModel);
		PokemonDTO pokemonDTOs = pokemonServiceIMP.guardarPokemon(pokemonDTO);
		assertThat(pokemonDTOs).isNotNull();

	}

	@DisplayName("Test para listar pokemon")
	@Test
	void testListarPokemon() {
		PokemonModel pokemonModels = new PokemonModel(1,"pokemon generico", "url generico" , "imageUrl generico");

		List<PokemonModel> pokemonModelList = Arrays.asList(pokemonModel,pokemonModels);
		Page<PokemonModel> pokemonModelPage = new PageImpl<>(pokemonModelList);

		given(pokemonRepository.findAll(any(Pageable.class))).willReturn(pokemonModelPage);

		PokemonRespDTO pokemonRespDTO = pokemonServiceIMP.obtenerPokemon(0, 10);

		assertThat(pokemonRespDTO.getContenido()).isNotNull();
		assertThat(pokemonRespDTO.getContenido().size()).isEqualTo(2);
	}

	@DisplayName("Test para actualizar pokemon")
	@Test
	void testActualizarPokemon() {


		given(pokemonRepository.save(pokemonModel)).willReturn(pokemonModel);
		given(pokemonRepository.findById(pokemonModel.getId())).willReturn(Optional.of(pokemonModel));

		pokemonModel.setPokemon("pokemon actualizado");
		pokemonModel.setImageUrl("imageUrl actualizado");
		pokemonModel.setUrl("url actualizado");

		given(pokemonRepository.save(pokemonModel)).willReturn(pokemonModel);

		pokemonDTO.setPokemon("pokemon actualizado");
		pokemonDTO.setImageUrl("imageUrl actualizado");
		pokemonDTO.setUrl("url actualizado");

		PokemonDTO pokemonDTOs = pokemonServiceIMP.actualizarPokemon(pokemonDTO, pokemonModel.getId());

		assertThat(pokemonDTOs.getPokemon()).isEqualTo("pokemon actualizado");
		assertThat(pokemonDTOs.getImageUrl()).isEqualTo("imageUrl actualizado");
		assertThat(pokemonDTOs.getUrl()).isEqualTo("url actualizado");
	}
}
