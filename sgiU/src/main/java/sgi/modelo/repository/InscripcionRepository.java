package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Inscripcion;


@Repository("inscripcionRepository")
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer>  {

}

