package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sgi.modelo.entidades.TipoCurso;

public interface TipoCursoRepository extends JpaRepository<TipoCurso, Integer>,
QueryByExampleExecutor<TipoCurso> {

}

