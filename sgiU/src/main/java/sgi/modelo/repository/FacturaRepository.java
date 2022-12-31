package sgi.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgi.modelo.entidades.Factura;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Integer>  {

}
