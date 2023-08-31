package com.ubp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ubp.model.PokemonModel;


@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel,Integer> {


    }









