package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sgi.modelo.entidades.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, Integer>,
QueryByExampleExecutor<Nivel> {

}
