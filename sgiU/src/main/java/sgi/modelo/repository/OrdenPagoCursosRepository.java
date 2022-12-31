package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.OrdenPagoCursos;


@Repository("ordenPagoCursosRepository")
public interface OrdenPagoCursosRepository extends JpaRepository<OrdenPagoCursos, Integer>  {

}

