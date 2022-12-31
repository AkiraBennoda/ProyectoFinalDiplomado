package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Persona;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Integer>  {

}
