package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Modalidad;

@Repository("modalidadRepository")
public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>,
QueryByExampleExecutor<Modalidad> {

}
