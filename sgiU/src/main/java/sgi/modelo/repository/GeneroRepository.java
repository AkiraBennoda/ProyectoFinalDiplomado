package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Genero;

@Repository("generoRepository")
public interface GeneroRepository extends JpaRepository<Genero, Integer>,
QueryByExampleExecutor<Genero> {

}
