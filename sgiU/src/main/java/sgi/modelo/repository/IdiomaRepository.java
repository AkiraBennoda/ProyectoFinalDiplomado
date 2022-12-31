package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Idioma;

@Repository("idiomaRepository")
public interface IdiomaRepository extends JpaRepository<Idioma, Integer>,
QueryByExampleExecutor<Idioma> {

}