package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Curso;

@Repository("cursoRepository")
public interface CursoRepository extends JpaRepository<Curso, Integer>  {

}

