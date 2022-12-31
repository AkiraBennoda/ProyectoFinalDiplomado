package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>  {

}
