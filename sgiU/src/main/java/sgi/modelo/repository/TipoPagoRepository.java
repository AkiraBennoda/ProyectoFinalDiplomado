package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Genero;
import sgi.modelo.entidades.TipoPago;

@Repository("tipoPagoRepository")
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> ,
QueryByExampleExecutor<TipoPago> {

}