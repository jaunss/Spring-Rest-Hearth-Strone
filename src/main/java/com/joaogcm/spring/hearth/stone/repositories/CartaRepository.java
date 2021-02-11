package com.joaogcm.spring.hearth.stone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.joaogcm.spring.hearth.stone.entities.Carta;
import com.joaogcm.spring.hearth.stone.entities.enums.Tipo;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {

	@Query("SELECT n FROM Carta n WHERE n.nome like %?1%")
	public Carta findByName(@Param("nome") String nome);
	
	@Query("SELECT n FROM Carta n WHERE n.tipo like %?1%")
	public Carta findByTipo(@Param("tipo") Tipo tipo);
}