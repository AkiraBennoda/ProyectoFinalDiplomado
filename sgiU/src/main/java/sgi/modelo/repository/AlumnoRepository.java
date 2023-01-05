package sgi.modelo.repository;


import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends PersonaRepository{

}
